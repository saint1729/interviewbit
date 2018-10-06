/*



https://www.interviewbit.com/problems/diffk-ii/



Diffk II
Asked in:  
Facebook
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.



*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(Integer i : A) {
            if(hs.contains(i+B) || hs.contains(i-B)) {
                return 1;
            }
            hs.add(i);
        }


        return 0;
        
    }
}
