/*

https://www.interviewbit.com/problems/length-of-last-word/


Length of Last Word
Asked in:  
Amazon
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.

*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        if(A == null || A.equals("")) {
            return 0;
        }
        Integer i = A.length()-1;
        while(i > -1) {
            if(A.charAt(i) == ' ') {
                i -= 1;
            } else {
                break;
            }
        }
        if(i == -1) {
            return 0;
        }
        Integer ans = 0;
        while(i > -1) {
            if(A.charAt(i) != ' ') {
                ans += 1;
            } else {
                break;
            }
            i -= 1;
        }
        return ans;
    }
}
