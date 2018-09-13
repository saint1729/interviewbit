/*

https://www.interviewbit.com/problems/palindrome-string/

Palindrome String
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem



*/
public class Solution {
    public int isPalindrome(String A) {
        
        if(A == null || A.equals("")) {
            return 1;
        }
        
        String B = A.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();

        return B.equals(new StringBuilder(B).reverse().toString()) ? 1 : 0;
    }
}
