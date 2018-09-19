/*

https://www.interviewbit.com/problems/first-missing-integer/

First Missing Integer
Asked in:  
Model N
InMobi
Amazon
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.

*/

public class Solution {
    
    public Integer segregate(ArrayList<Integer> A) {
        
        Integer j = 0;
        
        for(Integer i = 0; i < A.size(); i++) {
            Integer temp = A.get(i);
            if(temp <= 0) {
                A.set(i, A.get(j));
                A.set(j, temp);
                j++;
            }
        }
        
        return j;
    }
    
    public int firstMissingPositive(ArrayList<Integer> A) {
        
        //System.out.println(segregate(A));
        
        // for(Integer i = 0; i < A.size(); i++) {
        //     System.out.print(A.get(i) + " ");
        // }
        
        Integer start = segregate(A), N = A.size();
        
        for(Integer i = start; i < N; i++) {
            Integer x = A.get(i);
            Integer index = start+Math.abs(x)-1;
            if((index < N) && (A.get(index) > 0)) {
                A.set(index, -1*A.get(index));
            }
        }
        
        Integer i = 0;
        for(; i < N-start; i++) {
            if(A.get(i+start) > 0) {
                return i+1;
            }
        }
        
        return i+1;
    }
}
