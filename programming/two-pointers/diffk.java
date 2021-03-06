/*

https://www.interviewbit.com/problems/diffk/


Diffk
Asked in:  
Facebook
Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input : 
    A : [1 3 5] 
    k : 4
 Output : YES as 5 - 1 = 4 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.

*/


public class Solution {
    public int diffPossible(ArrayList<Integer> A, int B) {
        
        int left = 0, right = 1;
        
        if(A.size() < 2) {
            return 0;
        }
        
        while((left != A.size()) && (right != A.size())) {
            int diff = (A.get(right) - A.get(left));
            if((diff == B) && (left != right)) {
                return 1;
            } else if(diff < B) {
                right += 1;
            } else {
                left += 1;
            }
        }
        
        return 0;
        
    }
}
