/*



https://www.interviewbit.com/problems/length-of-longest-subsequence/


Length of Longest Subsequence
Asked in:  
Microsoft
Problem Setter: mayank111 Problem Tester: glowing_glare
Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6



*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        
        int[] lis = new int[A.size()];
        int[] lds = new int[A.size()];
        
        if(A.size() == 0) {
            return 0;
        }
        
        for(int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }
        
        for(int i = 1; i < lis.length; i++) {
            for(int j = 0; j < i; j++) {
                if(A.get(i).compareTo(A.get(j)) > 0) {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        
        for(int i = 0; i < lds.length; i++) {
            lds[i] = 1;
        }
        
        for(int i = lds.length-2; i >= 0; i--) {
            for(int j = lds.length-1; j > i; j--) {
                if(A.get(i).compareTo(A.get(j)) > 0) {
                    lds[i] = Math.max(lds[i], lds[j]+1);
                }
            }
        }
        
        int max = lis[0]+lds[0]-1;
        for(int i = 1; i < lis.length; i++) {
            max = Math.max(max, lis[i]+lds[i]-1);
        }
        
        return max;
    }
}
