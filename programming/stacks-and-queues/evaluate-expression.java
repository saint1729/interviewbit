/*



https://www.interviewbit.com/problems/evaluate-expression/



Evaluate Expression
Asked in:  
Yahoo
Google
Facebook
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


*/



public class Solution {
    public int evalRPN(String[] A) {
        
        Stack<Integer> st = new Stack<>();
    
        for(int i = 0; i < A.length; i++) {
            if(A[i].equals("+") || A[i].equals("-") ||
                A[i].equals("*") || A[i].equals("/")) {
                int first = st.pop();
                int second = st.pop();
                if(A[i].equals("+")) {
                    st.push(second+first);
                } else if(A[i].equals("-")) {
                    st.push(second-first);
                } else if(A[i].equals("*")) {
                    st.push(second*first);
                } else {
                    st.push(second/first);
                }
            }
            else {
                st.push(Integer.parseInt(A[i]));
            }
        }
        
        return st.peek();
        
        
    }
}
