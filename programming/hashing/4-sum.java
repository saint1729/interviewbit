/*



https://www.interviewbit.com/problems/4-sum/



4 Sum
Asked in:  
Amazon
Google
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])



*/




public class Solution {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        
        Collections.sort(A);
        
        Set<ArrayList<Integer>> solutionSet = new LinkedHashSet<>();
        
        for(int i = 0; i < A.size()-3; i++) {
            for(int j = i+1; j < A.size()-2; j++) {
                int k = j+1;
                int l = A.size()-1;
                int x = A.get(i);
                int y = A.get(j);
                while(k < l) {
                    int sum = A.get(i)+A.get(j)+A.get(k)+A.get(l);
                    if(sum == B) {
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.add(x);
                        solution.add(y);
                        solution.add(A.get(k));
                        solution.add(A.get(l));
                        if(!solutionSet.contains(solution)) {
                            solutionSet.add(solution);
                        }
                        k++;
                        l--;
                    } else if(sum < B) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>(solutionSet);

        return solutions;
    }
}
