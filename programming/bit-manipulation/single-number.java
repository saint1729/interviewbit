/*


https://www.interviewbit.com/problems/single-number/


Single Number
Asked in:  
Amazon
Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3



*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        
        Integer x = 0;
        
        for(Integer i = 0; i < A.size(); i++) {
            x ^= A.get(i);
        }
        
        return x;
        
    }
}
