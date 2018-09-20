/*

https://www.interviewbit.com/problems/greatest-common-divisor/

Greatest Common Divisor
Asked in:  
NetApp
Google
Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

m : 6
n : 9

GCD(m, n) : 3 
 NOTE : DO NOT USE LIBRARY FUNCTIONS 

*/


public class Solution {
    public int gcd(int A, int B) {
        
        while(A != 0 && B != 0) {
            if(A < B) {
                A = A+B;
                B = A-B;
                A = A-B;
            }
            Integer C = B;
            B = A%B;
            A = C;
        }
        
        return A+B;
        
    }
}
