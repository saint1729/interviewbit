/*


https://www.interviewbit.com/problems/majority-element/


Majority Element
Asked in:  
Microsoft
Yahoo
Google
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 


*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        
        int majority = A.get(0), count = 1;
        
        for(int i = 1; i < A.size(); i++) {
            if(A.get(i).equals(majority)) {
                count += 1;
            } else {
                count -= 1;
            }
            if(count == 0) {
                majority = A.get(i);
                count = 1;
            }
        }
        
        return majority;
    }
}
