/*


https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/


Merge Two Sorted Lists II
Asked in:  
Adobe
Expedia
Microsoft
Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result. 
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]

*/


public class Solution {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        
        int i = 0, j = 0;
        for(; (i < a.size() && j < b.size());) {
            if(a.get(i).compareTo(b.get(j)) < 0) {
                i++;
            } else {
                a.add(i, b.get(j));
                i++;
                j++;
            }
        }
        
        if(i == a.size()) {
            a.add(b.get(j));
            j++;
        }
        
    }
}
