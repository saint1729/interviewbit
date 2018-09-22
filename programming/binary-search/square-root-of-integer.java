/*


https://www.interviewbit.com/problems/square-root-of-integer/


Square Root of Integer
Asked in:  
Facebook
Amazon
Microsoft
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

*/



public class Solution {
    public int sqrt(int a) {
        
        if((a == 0) || (a == 1)) {
            return a;
        }
        
        long A = a;
        
        long ans = 0, start = 1, end = A;
        
        while(start <= end) {
            long mid = (start+end)/2;
            if(mid*mid == A) {
                return (int)mid;
            } else if(mid*mid < A){
                start = mid+1;
                ans = mid;
            } else {
                end = mid-1;
            }
        }
        
        return (int)ans;
    }
}
