/*


https://www.interviewbit.com/problems/reverse-integer/

Reverse integer
Asked in:  
HCL
Bloomberg
Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer

*/

public class Solution {
    public int reverse(int A) {
        
        Boolean sign = (A >= 0) ? true : false;
        
        if(!sign) {
            A = -1*A;
        }
        
        Integer ans = 0, mod = 0, prevAns = 0;
        
        while(A > 0) {
            mod = A%10;
            ans = ans*10+mod;
            
            if((ans-mod)/10 != prevAns) {
                return 0;
            }
            
            prevAns = ans;
            A /= 10;
        }
        
        if(!sign) {
            ans = -1*ans;
        }
        
        return ans;
        
    }
}
