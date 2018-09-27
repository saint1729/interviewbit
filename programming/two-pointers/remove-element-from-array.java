/*

https://www.interviewbit.com/problems/remove-element-from-array/


Remove Element from Array
Asked in:  
Amazon
Remove Element

Given an array and a value, remove all the instances of that value in the array. 
Also return the number of elements left in the array after the operation.
It does not matter what is left beyond the expected length.

 Example:
If array A is [4, 1, 1, 2, 1, 3]
and value elem is 1, 
then new length is 3, and A is now [4, 2, 3] 
Try to do it in less than linear additional space complexity.

*/

public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        
        int j = 0, n = a.size();
        
        for(int i = 0; i < n; i++) {
            if(!a.get(i).equals(b)) {
                int temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
                j++;
            }
        }
        
        if(j < a.size()) {
            a.subList(j, a.size()).clear();
        }
        
        return a.size();
    }
}