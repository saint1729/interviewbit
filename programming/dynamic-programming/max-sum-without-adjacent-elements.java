/*




https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/




Max Sum Without Adjacent Elements
Asked in:  
Epic systems
Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Example:

Grid:
	1 2 3 4
	2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8


Note that you can choose more than 2 numbers




*/




public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int excl = 0;
        int incl = Math.max(A.get(0).get(0), A.get(1).get(0));
        
        for (int i = 1; i < A.get(0).size(); i++ ) {
            int excl_new = Math.max(excl, incl);
            incl = excl + Math.max(A.get(0).get(i), A.get(1).get(i));
            excl = excl_new;
        }
        
        return Math.max(excl, incl);
    
    }
}
