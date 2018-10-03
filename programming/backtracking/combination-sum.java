/*


https://www.interviewbit.com/problems/combination-sum/


Combination Sum
Asked in:  
Facebook
Amazon
Adobe
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 


*/


public class Solution {

    public void combinationSumUtil(ArrayList<Integer> A, int sum, ArrayList<Integer> l,
                                int index, ArrayList<ArrayList<Integer>> ans) {
        if(sum < 0) {
            return;
        } else if(sum == 0) {
            ans.add(new ArrayList<Integer>(l));
            return;
        } else {
            for(;index < A.size(); index++) {
                l.add(A.get(index));
                combinationSumUtil(A, sum-A.get(index), l, index, ans);
                l.remove(l.size()-1);
            }
            return;
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> l = new ArrayList<Integer>();

        Set<Integer> hs = new HashSet<>();
        hs.addAll(A);
        A.clear();
        A.addAll(hs);
        
        Collections.sort(A);
        
        combinationSumUtil(A, B, l, 0, ans);
        
        return ans;
    }
}
