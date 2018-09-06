/*

https://www.interviewbit.com/problems/largest-rectangle-in-histogram/


Largest Rectangle in Histogram
Asked in:  
Google
Facebook
Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.



*/


public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        
        Stack<Integer> s = new Stack<>();
        int maxArea = 0, i = 0;
        
        for(; i < A.size();) {
            if((s.empty()) || (A.get(s.peek()) <= A.get(i))) {
                s.push(i);
                i++;
            } else {
                int top = s.pop();
                int currentArea = A.get(top)*(s.empty() ? i : (i-s.peek()-1));
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        
        while(!s.empty()) {
            int top = s.pop();
            int currentArea = A.get(top)*(s.empty() ? i : (i-s.peek()-1));
            maxArea = Math.max(maxArea, currentArea);
        }
        
        return maxArea;
    }
}
