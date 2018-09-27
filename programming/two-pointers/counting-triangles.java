/*

https://www.interviewbit.com/problems/counting-triangles/

Counting Triangles
You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4

*/

public class Solution {
    
    public boolean isTriangle(int a, int b, int c) {
        if(a+b <= c) {
            return false;
        }
        return true;
    }
    
    public int nTriang(int[] A) {
        
        int n = A.length, ans = 0, p = 1000000007;
        
        if(n < 3) {
            return 0;
        }
        
        Arrays.sort(A);
        
        for(int i = 0; i < n-2; i++) {
            int k = i+2;
            for(int j = i+1; (j < n-1 && k <= n); j++) {
                while((k < n) && (isTriangle(A[i], A[j], A[k]))) {
                    k++;
                }
                
                ans = (ans+(k-j-1)%p)%p;
            }
        }
        
        return ans;
    }
}
