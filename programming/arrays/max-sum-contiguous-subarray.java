/*

https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

Max Sum Contiguous Subarray
Asked in:  
Facebook
Paypal
Yahoo
Microsoft
LinkedIn
Amazon
Goldman Sachs
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.



*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        Integer meh = A.get(0);
        Integer msf = A.get(0);
        
        for(Integer i = 1; i < A.size(); i++) {
            meh = Math.max(A.get(i), meh+A.get(i));
            msf = Math.max(msf, meh);
        }
        
        return msf;
    }
}
