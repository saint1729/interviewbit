/*


https://www.interviewbit.com/problems/minimize-the-absolute-difference/


Minimize the absolute difference
Asked in:  
Microsoft
Problem Setter: ganeshk2 Problem Tester: dhruvi
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.



*/


public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        
        Integer i = 0, j = 0, k = 0, L = A.size(), M = B.size(), N = C.size();
        
        if(L == 0 && M == 0 && N == 0) {
            return 0;
        }
        
        Integer ans = Integer.MAX_VALUE;
        
        while((i < L) && (j < M) && (k < N)) {
            Integer min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            Integer max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            
            ans = Math.min(ans, max-min);
            
            if(ans == 0) {
                return 0;
            }
            
            if(A.get(i).equals(min)) {
                i++;
            } else if(B.get(j).equals(min)) {
                j++;
            } else {
                k++;
            }
        }
        
        return ans;
    }
}
