/*


https://www.interviewbit.com/problems/max-continuous-series-of-1s/

Max Continuous Series of 1s
Asked in:  
VMWare
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.


*/


public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        
        int left = 0, right = 0, zeroes = 0;
        int bestLeft = 0, bestRight = 0, bestWidth = 0;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while(right < A.size()) {
            if(zeroes <= B) {
                if(A.get(right).equals(0)) {
                    zeroes += 1;
                }
                right += 1;
            }
            if(zeroes > B) {
                if(A.get(left).equals(0)) {
                    zeroes -= 1;
                }
                left += 1;
            }
            if((right-left) > bestWidth) {
                bestWidth = right-left;
                bestLeft = left;
                bestRight = right;
            }
        }
        
        for(int i = bestLeft-1; i > -1; i--) {
            if(A.get(i).equals(0)) {
                break;
            }
            ans.add(i);
        }
        
        Collections.reverse(ans);
        for(int i = bestLeft; i < bestRight; i++) {
            ans.add(i);
        }
        for(int i = bestRight; i < A.size(); i++) {
            if(A.get(i).equals(0)) {
                break;
            }
            ans.add(i);
        }

        return ans;
    }
}
