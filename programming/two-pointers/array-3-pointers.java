/*

https://www.interviewbit.com/problems/array-3-pointers/

Array 3 Pointers
Asked in:  
Google
Microsoft
Yahoo
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 

*/


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        
        int diff = Integer.MAX_VALUE, p = A.length, q = B.length, r = C.length; // Initialize min diff
     
        // Initialize result
        int res_i =0, res_j = 0, res_k = 0;
     
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r)
        {
            int minimum = Math.min(A[i],
                          Math.min(B[j], C[k]));
            int maximum = Math.max(A[i], 
                          Math.max(B[j], C[k]));
     
            if (maximum-minimum < diff)
            {
                res_i = i;
                res_j = j;
                res_k = k;
                diff = maximum - minimum;
            }
     
            if (diff == 0) {
                return 0;
            }
     
            if (A[i] == minimum) i++;
            else if (B[j] == minimum) j++;
            else k++;
        }
     
        return diff;
    }
}
