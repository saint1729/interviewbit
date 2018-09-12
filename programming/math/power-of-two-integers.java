/*


https://www.interviewbit.com/problems/power-of-two-integers/


Power Of Two Integers
Asked in:  
Housing
Amazon
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

*/



public class Solution {
    public int isPower(int A) {
        
        if(A == 1) {
            return 1;
        }
        
        Integer y = 2;
        for(Integer x = 2; x <= (int)Math.sqrt(A); x++) {
            
            Integer p = A;
            
            while(p%x == 0) {
                p /= x;
            }
            
            if(p == 1) {
                return 1;
            }
            
        }
        return 0;
    }
}
