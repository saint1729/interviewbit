/*

https://www.interviewbit.com/problems/palindrome-integer/

Palindrome Integer
Asked in:  
HCL
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

*/

public class Solution {
    public int isPalindrome(int A) {
        
        Integer temp = A, rev = 0;
        
        while(temp > 0) {
            Integer mod = temp%10;
            rev = 10*rev+mod;
            temp /= 10;
        }
        
        return (A==rev) ? 1:0;
        
    }
}
