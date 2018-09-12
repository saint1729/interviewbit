/*

https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/

Minimum Characters required to make a String Palindromic
You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string

Example:
Input: ABC
Output: 2
Input: AACECAAAA
Output: 2

*/


public class Solution {
    
    public ArrayList<Integer> lpsArray(String s) {
        
        int n = s.length(), len = 0;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        ans.add(0);
        
        for(int i = 1; i < n;) {
            if(s.charAt(i) == s.charAt(len)) {
                len += 1;
                ans.add(len);
                i += 1;
            } else {
                if(len == 0) {
                    ans.add(0);
                    i += 1;
                } else {
                    len = ans.get(len-1);
                }
            }
        }
        
        return ans;
    }
    
    public int solve(String A) {
        
        String s = A + "`" + new StringBuilder(A).reverse().toString();
        
        ArrayList<Integer> lps = lpsArray(s);
        
        return A.length()-lps.get(lps.size()-1);
        
    }
}
