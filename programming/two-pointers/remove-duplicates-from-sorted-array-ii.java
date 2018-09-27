/*

https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/

Remove Duplicates from Sorted Array II
Asked in:  
Expedia
Microsoft
Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].

*/


public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        if(a.size() < 3) {
            return a.size();
        }
        
        Integer i = 1, j = 1;
        
        while(i < a.size()) {
            if((i+1 < a.size()) && a.get(i).equals(a.get(i-1)) && a.get(i).equals(a.get(i+1))) {
                i += 1;
            } else {
                a.set(j, a.get(i));
                i += 1;
                j += 1;
            }
        }
        
        a.subList(j, a.size()).clear();
        
        return a.size();
    }
}
