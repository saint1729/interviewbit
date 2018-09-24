/*

https://www.interviewbit.com/problems/reverse-the-string/

Reverse the String
Asked in:  
Qualcomm
Amazon
Microsoft
Cisco
Facebook
Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

*/

public class Solution {
    public String reverseWords(String a) {
        String delimiter = " ";
        String [] tokens = a.split(java.util.regex.Pattern.quote(delimiter));
        StringBuffer ans = new StringBuffer();
        for(Integer i = tokens.length-1; i > -1; i--) {
            ans.append(tokens[i] + " ");
        }
        return ans.toString().trim();
    }
}
