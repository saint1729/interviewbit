/*


https://www.interviewbit.com/problems/longest-valid-parentheses/



Longest valid Parentheses
Asked in:  
Google
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.



*/



public class Solution {
    public int longestValidParentheses(String A) {
        
        Stack<Integer> s = new Stack<Integer>();
        
        s.push(-1);
        
        int ans = 0;
        
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(') {
                s.push(i);
            } else {
                s.pop();
                
                if(!s.empty()) {
                    ans = Math.max(ans, i-s.peek());
                } else {
                    s.push(i);
                }
            }
        }
        
        return ans;
    }
}
