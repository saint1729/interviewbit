/*


https://www.interviewbit.com/problems/combinations/


Combinations
Asked in:  
Amazon
Adobe
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 


*/




public class Solution {
    
    public void combineUtil(int A, int K, int start, ArrayList<Integer> l,
                                ArrayList<ArrayList<Integer>> B) {
        if(l.size() == K) {
            B.add(new ArrayList<Integer>(l));
            return;
        }
        for(int i = start; i <= A; i++) {
            l.add(i);
            combineUtil(A, K, i+1, l, B);
            l.remove(l.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if((B <= 0) && (B > A)) {
            return ans;
        }
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        combineUtil(A, B, 1, l, ans);
        
        return ans;
    }
}
