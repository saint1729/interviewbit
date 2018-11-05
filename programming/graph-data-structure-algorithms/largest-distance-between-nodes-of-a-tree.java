/*



https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/


Largest Distance between nodes of a Tree
Asked in:  
Facebook
Google
Problem Setter: ulugbek_adilbekov Problem Tester: raghav_aggiwal
Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
          0
       /  |  \
      1   2   3
               \
                4  
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance. 


*/



public class Solution {
    
    public class Graph {
        int V;
        ArrayList<Integer>[] adj;
        int root = -1;
        
        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList[V];
            for(int i = 0; i < V; i++) {
                this.adj[i] = new ArrayList<>();
            }
        }
        
        public void addNode(int src, int dest) {
            this.adj[src].add(dest);
            this.adj[dest].add(src);
            return;
        }
    }
    
    public void constructGraph(Graph g, ArrayList<Integer> A) {
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i).equals(-1)) {
                g.root = i;
            } else {
                g.addNode(A.get(i), i);
            }
        }
        return;
    }
    
    public void printGraph(Graph g) {
        int N = g.adj.length;
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> l = g.adj[i];
            System.out.print(i + "\t");
            for(int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public ArrayList<Integer> bfs(Graph g, int node) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int maxDist = -1, maxIndex = -1;
        int[] dist = new int[g.V];
        Arrays.fill(dist, -1);
        q.add(node);
        dist[node] = 0;
        while(!q.isEmpty()) {
            int top = q.poll();
            for(int i = 0; i < g.adj[top].size(); i++) {
                int v = g.adj[top].get(i);
                if(dist[v] == -1) {
                    q.add(v);
                    dist[v] = dist[top]+1;
                }
            }
        }
        
        for(int i = 0; i < g.V; i++) {
            if(maxDist < dist[i]) {
                maxDist = dist[i];
                maxIndex = i;
            }
        }
        
        ans.add(maxIndex);
        ans.add(maxDist);
        
        
        
        return ans;
    }
    
    public int solve(ArrayList<Integer> A) {
        
        int N = A.size(), ans = 0;
        
        Graph g = new Graph(N);
        
        constructGraph(g, A);
        
        // printGraph(g);
        
        int root = g.root;
        
        // System.out.println(root);
        
        ArrayList<Integer> l = bfs(g, root);
        
        l = bfs(g, l.get(0));
        
        ans = l.get(1);
        
        return ans;
    }
}
