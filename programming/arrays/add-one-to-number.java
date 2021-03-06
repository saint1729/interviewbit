/*

https://www.interviewbit.com/problems/add-one-to-number/

Add One To Number
Asked in:  
Google
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

*/

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        for(int i = A.size()-1; i > -1; i--) {
            if(A.get(i) == 9) {
                A.set(i, 0);
            } else {
                A.set(i, A.get(i)+1);
                break;
            }
        }
        
        int i = 0;
        for(; i < A.size(); i++) {
            if(A.get(i) != 0) {
                break;
            }
        }
        
        if(i == A.size()) {
            A.add(0, 1);
            return A;
        } else {
            return new ArrayList(A.subList(i, A.size()));
        }
        
        
    }
}
