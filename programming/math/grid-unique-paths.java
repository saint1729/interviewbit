/*

https://www.interviewbit.com/problems/grid-unique-paths/

Grid Unique Paths
Asked in:  
Google
Amazon
Microsoft
Adobe
A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)

*/


public class Solution {
    public int uniquePaths(int A, int B) {
        
        if(A == 0 || B == 0) {
            return 0;
        }
        
        if(A == 1 || B == 1) {
            return 1;
        }
        
        int[][] c = new int[A][B];
        
        for(Integer i = 0; i < A; i++) {
            c[i][0] = 1;
        }
        
        for(Integer i = 0; i < B; i++) {
            c[0][i] = 1;
        }
        
        for(Integer i = 1; i < A; i++) {
            for(Integer j = 1; j < B; j++) {
                c[i][j] = c[i-1][j]+c[i][j-1];
            }
        }
        
        return c[A-1][B-1];
        
    }
}
