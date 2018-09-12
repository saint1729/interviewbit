/*

https://www.interviewbit.com/problems/reverse-bits/

Reverse Bits
Asked in:  
Nvidia
HCL
Amazon
Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long

*/



public class Solution {
    public long reverse(long a) {
        
        int bits[] = new int[32];
        
        long ans = 0;
        
        for(int i = 0; i < 32; i++) {
            ans = (ans << 1)+(a%2);
            a = a >> 1;
        }
        
        return ans;
        
    }
}
