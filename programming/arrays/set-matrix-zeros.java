/*

https://www.interviewbit.com/problems/set-matrix-zeros/

Set Matrix Zeros
Asked in:  
Oracle
Amazon
Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1 
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1
Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.

*/

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        
        Boolean firstRowHasZero = false;
        Boolean firstColumnHasZero = false;
        
        for(Integer i = 0; i < a.get(0).size(); i++) {
            if(a.get(0).get(i) == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        for(Integer i = 0; i < a.size(); i++) {
            if(a.get(i).get(0) == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for(Integer i = 1; i < a.size(); i++) {
            for(Integer j = 1; j < a.get(0).size(); j++) {
                Integer x = a.get(i).get(j);
                if(x == 0) {
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);
                }
            }
        }
        
        for(Integer i = 1; i < a.size(); i++) {
            for(Integer j = 1; j < a.get(0).size(); j++) {
                Integer x = a.get(0).get(j);
                Integer y = a.get(i).get(0);
                if(x == 0 || y == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }
        
        if(firstRowHasZero) {
            for(Integer i = 0; i < a.get(0).size(); i++) {
                a.get(0).set(i, 0);
            }
        }
        
        if(firstColumnHasZero) {
            for(Integer i = 0; i < a.size(); i++) {
                a.get(i).set(0, 0);
            }
        }
        
    }
}
