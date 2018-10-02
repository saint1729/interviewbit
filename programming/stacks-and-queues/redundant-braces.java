/*



https://www.interviewbit.com/problems/redundant-braces/



Redundant Braces
Asked in:  
Amazon
Write a program to validate if the input string has redundant braces?
Return 0/1

0 -> NO
1 -> YES
Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0




*/



public class Solution {
    public int braces(String A) {
        
        char[] cArray = A.toCharArray();
        
        Stack<Character> s = new Stack<Character>();
        
        for(char c : cArray) {
            if(c == ')') {
                char pop = s.pop();
                boolean flag = true;
                while(pop != '(') {
                    if((pop == '+') || (pop == '-') ||
                        (pop == '*') || (pop == '/')) {
                        // System.out.println(pop + " ");
                        flag = false;
                    }
                    pop = s.pop();
                }
                // System.out.println("flag = " + flag + " stack = " + s);
                if(flag == true) {
                    return 1;
                }
            } else {
                s.push(c);
            }
        }
        
        return 0;
    }
}
