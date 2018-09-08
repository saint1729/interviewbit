/*

https://www.interviewbit.com/problems/2-sum/

2 Sum
Asked in:  
Facebook
Amazon
Google
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        
        for(int i = 0; i < A.size(); i++) {
            ArrayList<Integer> l = m.getOrDefault(A.get(i), new ArrayList<Integer>());
            l.add(i+1);
            m.putIfAbsent(A.get(i), l);
        }
        
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < A.size(); i++) {
            
            int first = A.get(i);
            int second = B-A.get(i);
            
            
            if(m.containsKey(second)) {
                ArrayList<Integer> l = m.get(second);
                int firstIndex = i+1;
                int secondIndex = (first == second) ?
                            ((l.size() > 1) ?
                            ((l.get(0) == firstIndex) ? l.get(1)
                            : l.get(0))
                            : -1)
                            : l.get(0);
                // System.out.println(firstIndex);
                if(secondIndex == -1) {
                    continue;
                }
                ArrayList<Integer> solution = new ArrayList<>();
                solution.add(firstIndex);
                solution.add(secondIndex);
                Collections.sort(solution);
                solutions.add(solution);
            }
        }
        
        Collections.sort(solutions, new Comparator<ArrayList<Integer>>() {
                        
                        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                            if(a.get(1) < b.get(1)) {
                                return -1;
                            } else if(a.get(1).equals(b.get(1))) {
                                if(a.get(0) < b.get(0)) {
                                    return -1;
                                } else {
                                    return 1;
                                }
                            } else {
                                return 1;
                            }
                        }
                    
                    });
        
        // System.out.println(solutions);
        
        return (solutions.size() == 0) ? (new ArrayList<Integer>()) : solutions.get(0);
    }
}
