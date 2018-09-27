/*

https://www.interviewbit.com/problems/3-sum-zero/

3 Sum Zero
Asked in:  
Facebook
Google
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2) 

*/


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if(A == null || A.size() < 3) {
            return ans;
        }
        
        Collections.sort(A);
        
        for(int i = 0; i < A.size()-2; i++) {
            if((i == 0) || (A.get(i).compareTo(A.get(i-1)) > 0)) {
                int j = i+1;
                int k = A.size()-1;
                while(j < k) {
                    int sum = A.get(i)+A.get(j)+A.get(k);
                    if(sum == 0) {
                        ArrayList<Integer> solution = new ArrayList<Integer>();
                        solution.add(A.get(i));
                        solution.add(A.get(j));
                        solution.add(A.get(k));
                        ans.add(solution);
                        while((j < k) && (A.get(j+1).equals(A.get(j)))) {
                            j += 1;
                        }
                        while((k > j) && (A.get(k-1).equals(A.get(k)))) {
                            k -= 1;
                        }
                        j++;
                        k--;
                    } else if(sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
