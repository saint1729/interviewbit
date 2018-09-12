/*

https://www.interviewbit.com/problems/single-number-ii/

Single Number II
Asked in:  
Google
Amazon
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4


*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        
        int N = A.size(), sum = 0, ans = 0, x;
        
        for(Integer i = 0; i < 32; i++) {
            sum = 0;
            x = 1 << i;
            for(Integer j = 0; j < N; j++) {
                Integer bit = (x&A.get(j));
                // System.out.print(bit + " ");
                if(bit == 0) {
                    sum++;
                }
                // System.out.print(sum + " ");
            }
            // System.out.print(sum + " " + ans + " ");
            if(sum%3 == 0) {
                ans |= x;
            }
            // System.out.print(ans + "  ");
        }
        
        return ans;
    }
}
