/*

https://www.interviewbit.com/problems/implement-power-function/

Implement Power Function
Asked in:  
Google
LinkedIn
Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.

*/

public class Solution {
    public int pow(int x, int n, int d) {
        
        long X = x;

        d = (d < 0) ? -d : d;
        
        if((x == 0) || (d == 1)) {
            return 0;
        }
        
        if(n == 0) {
            return 1;
        }
        
        long prod = 1;
        X %= d;
        
        while(n > 0) {
            if((n & 1) == 1) {
                prod = (prod*X)%d;
                // System.out.print("prod = " + prod + " ");
            }
            n = n>>1;
            X = (X*X)%d;
            // System.out.print("x = " + x);
            // System.out.println();
        }
        
        return (int)((prod < 0) ? (d+(x%d)) : prod);
    }
}
