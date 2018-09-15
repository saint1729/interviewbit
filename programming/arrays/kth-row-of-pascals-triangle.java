/*

https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/

Kth Row of Pascal's Triangle
Asked in:  
Google
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?

*/

public class Solution {
    public ArrayList<Integer> getRow(int A) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        

        ArrayList<Integer> zeroth = new ArrayList<Integer>();
        zeroth.add(1);
        ans.add(zeroth);
        if(A == 0) {
            return ans.get(0);
        }
        
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        first.add(1);
        ans.add(first);
        if(A == 1) {
            return ans.get(1);
        }
        
        
        for(int i = 2; i <= A; i++) {
            ArrayList<Integer> X = new ArrayList<Integer>();
            X.add(1);
            for(int j = 0; j < i-1; j++) {
                X.add(ans.get(i-1).get(j)+ans.get(i-1).get(j+1));
            }
            X.add(1);
            ans.add(X);
        }
        return ans.get(A);
        
    }
}
