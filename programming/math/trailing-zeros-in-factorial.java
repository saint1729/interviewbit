/*

https://www.interviewbit.com/problems/trailing-zeros-in-factorial/


Trailing Zeros in Factorial
Asked in:  
Microsoft
Jabong
Zillow
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1

*/

public class Solution {
    public int trailingZeroes(int A) {
        
        Integer zeroes = 0;
        
        while(A/5 > 0) {
            zeroes += A/5;
            A /= 5;
        }
        
        
        return zeroes;
    }
}
