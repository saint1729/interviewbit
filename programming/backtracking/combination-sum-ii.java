/*


https://www.interviewbit.com/problems/combination-sum-ii/


Combination Sum II
Asked in:  
Microsoft
Amazon
Infosys
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 



*/



public class Solution {
    
    public void combinationSumUtil(ArrayList<Integer> a, int sum, int index,
                                ArrayList<Integer> l, ArrayList<ArrayList<Integer>> ans) {
        
        if(sum < 0) {
            return;
        } else if(sum == 0) {
            ans.add(new ArrayList<Integer>(l));
            return;
        } else {
            int prev = -1;
            for(int i = index; i < a.size(); i++) {
                if(a.get(i).compareTo(prev) != 0) {
                    l.add(a.get(i));
                    combinationSumUtil(a, sum-a.get(i), i+1, l, ans);
                    l.remove(l.size()-1);
                    prev = a.get(i);
                }
            }
            return;
        }
        
    }
    
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        for(int i = a.size()-1; i >= 0; i--) {
            if(a.get(i).compareTo(b) > 0) {
                a.remove(i);
            } else {
                break;
            }
        }
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        combinationSumUtil(a, b, 0, l, ans);
        
        return ans;
    }
}
