/*

https://www.interviewbit.com/problems/max-distance/


Max Distance
Asked in:  
Google
Amazon
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)



*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        List<Integer> indices = new ArrayList<Integer>();
        
        if(A.size() == 0) {
            return -1;
        }
        
        if(A.size() == 1) {
            return 0;
        }
        

        for(Integer i = 0; i < A.size(); i++) {
            indices.add(i);
        }
        
        //Collections.sort(A);
        
        Collections.sort(indices, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (A.get(a) < A.get(b)) ? -1 : 1;
            }
        });
        
        int max_diff = Integer.MIN_VALUE;
        int min_index = Integer.MAX_VALUE;
        
        for(Integer i = 0; i < indices.size(); i++) {
            if(indices.get(i) < min_index) {
                min_index = indices.get(i);
            }
            max_diff = Math.max(max_diff, indices.get(i)-min_index);
        }
        
        if(max_diff == 0) {
            //return -1;
        }
        
        return max_diff;
    }
}
