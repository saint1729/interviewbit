/*



https://www.interviewbit.com/problems/clone-graph/


Clone Graph
Asked in:  
Google
Facebook
Amazon
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.



*/





/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>();
        
        UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
        
        q.offer(node);
        m.put(node, ans);
        while(!q.isEmpty()) {
            UndirectedGraphNode top = q.poll();
            List<UndirectedGraphNode> l = top.neighbors;
            
            for(UndirectedGraphNode n:l) {
                if(!m.containsKey(n)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                    m.put(n, newNode);
                    m.get(top).neighbors.add(newNode);
                    q.offer(n);
                } else {
                    m.get(top).neighbors.add(m.get(n));
                }
            }
        }
        
        return ans;
    }
}
