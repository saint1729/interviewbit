/*


https://www.interviewbit.com/problems/rain-water-trapped/



Rain Water Trapped
Asked in:  
Qualcomm
Amazon
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example :

Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Rain water trapped: Example 1

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.


*/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        
        int low = 0, high = A.size()-1, leftMax = 0, rightMax = 0, ans = 0;
        
        while(low < high) {
            if(A.get(low).compareTo(A.get(high)) < 0) {
                if(A.get(low).compareTo(leftMax) > 0) {
                    leftMax = A.get(low);
                } else {
                    ans += (leftMax-A.get(low));
                }
                low += 1;
            } else {
                if(A.get(high).compareTo(rightMax) > 0) {
                    rightMax = A.get(high);
                } else {
                    ans += (rightMax-A.get(high));
                }
                high -= 1;
            }
        }
        
        return ans;
    }
}
