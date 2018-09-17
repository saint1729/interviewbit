/*

https://www.interviewbit.com/problems/noble-integer/


Noble Integer
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.


*/

public class Solution {
    
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        Integer n = A.size();
        for(Integer i = 0; i < n-1; i++) {
            if((A.get(i) == n-i-1) && (A.get(i) != A.get(i+1))) {
                return 1;
            }
        }
        if(A.get(n-1) == 0) {
            return 1;
        }
        return -1;
    }
}
