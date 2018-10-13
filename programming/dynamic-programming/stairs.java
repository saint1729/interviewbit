/*



https://www.interviewbit.com/problems/stairs/


Stairs
Asked in:  
Morgan Stanley
Amazon
Intel
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]



*/

public class Solution {
    public int climbStairs(int A) {
        
        if(A < 3) {
            return A; 
        }
        
        int a = 1, b = 2, c = 3;
        
        int i = 2;
        
        while(i < A) {
            c = a+b;
            a = b;
            b = c;
            i += 1;
        }
        
        return c;
        
    }
}
