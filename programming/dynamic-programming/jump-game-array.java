/*


Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem


*/


public class Solution {
    public int canJump(ArrayList<Integer> A) {
        if(A.size() < 2) {
            return 1;
        }
        
        int maxIndex = A.get(0);
        
        for(int i = 0; i < A.size(); i++) {
            if((maxIndex <= i) && (A.get(i) == 0)) {
                return 0;
            } else {
                maxIndex = Math.max(maxIndex, i+A.get(i));
                if(maxIndex >= A.size()-1) {
                    return 1;
                }
            }
        }
        
        return 0;
    }
}
