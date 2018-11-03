/*




https://www.interviewbit.com/problems/black-shapes/




Black Shapes
Asked in:  
Amazon
Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.




*/




public class Solution {

    int M, N;
    int row[] = {-1, 0, 0, 1};
    int col[] = {0, -1, 1, 0};

    public void print(boolean[][] visited) {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean belongsTo(ArrayList<String> A, boolean[][] visited, int r, int c) {
        
        return (r > -1) && (r < M) && (c > -1) && (c < N)
                && (A.get(r).charAt(c) == 'X') && !visited[r][c];
        
    }

    public void DFS(ArrayList<String> A, boolean[][] visited, int i, int j) {
        
        visited[i][j] = true;
        
        for(int k = 0; k < 4; k++) {
            // System.out.print((i+row[k]) + " " + (j+row[k]) + "  ");
            if(belongsTo(A, visited, i+row[k], j+col[k])) {
                DFS(A, visited, i+row[k], j+col[k]);
            }
            // System.out.println();
        }
    }

    public int totalNumberOfBlackShapes(ArrayList<String> A) {

        int count = 0;
        boolean[][] visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if((A.get(i).charAt(j) == 'X') && !visited[i][j]) {
                    DFS(A, visited, i, j);
                    // print(visited);
                    count += 1;
                }
            }
        }
        
        return count;
    }

    public int black(ArrayList<String> A) {
        
        int ans = 0;
        if(A.size() == 0) {
            return ans;
        }
        
        M = A.size();
        N = A.get(0).length();
        
        ans = totalNumberOfBlackShapes(A);
        
        return ans;
    }
}
