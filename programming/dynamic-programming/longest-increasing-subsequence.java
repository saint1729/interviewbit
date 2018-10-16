/*



https://www.interviewbit.com/problems/longest-increasing-subsequence/



Longest Increasing Subsequence
Asked in:  
Facebook
Yahoo
Epic systems
Amazon
Microsoft
Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]




*/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        
        int l[] = new int[A.size()];
        int i, j, max = 0;
        
        for(i = 0; i < A.size(); i++) {
          l[i] = 1;
        }
        
        for(i = 1; i < A.size(); i++) {
            for(j = 0; j < i; j++) {
                if((A.get(i) > A.get(j)) && (l[i] < l[j]+1)) {
                    l[i] = l[j] + 1;
                }
            }
        }
        
        for(i = 0; i < A.size(); i++) {
            if(max < l[i]) {
                max = l[i];
            }
        }
        
        return max;
    }
}
