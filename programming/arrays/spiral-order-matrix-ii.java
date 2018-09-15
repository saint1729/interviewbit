/*

https://www.interviewbit.com/problems/spiral-order-matrix-ii/

Spiral Order Matrix II
Asked in:  
Microsoft
JP Morgan
Amazon
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]

*/


public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        
        ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>>();
        
        for (Integer i = 0; i < A; i++) {
            M.add(new ArrayList<>());
            for (Integer j = 0; j < A; j++) {
                M.get(i).add(0);
            }
        }

        Integer T = 0, B = A-1, L = 0, R = A-1, dir = 0, n = 1, x = 0;
        
        while((T <= B) && (L <= R)) {
            
            if(dir == 0) {
                for(Integer i = L; i <= R; i++) {
                    M.get(T).set(i, n++);
                }
                T++;
            } else if(dir == 1) {
                for(Integer i = T; i <= B; i++) {
                    M.get(i).set(R, n++);
                }
                R--;
            } else if(dir == 2) {
                for(Integer i = R; i >= L; i--) {
                    M.get(B).set(i, n++);
                }
                B--;
            } else if(dir == 3) {
                for(Integer i = B; i >= T; i--) {
                    M.get(i).set(L, n++);
                }
                L++;
            }
            
            dir = (dir+1)%4;
        }
        
        return M;
    }
}
