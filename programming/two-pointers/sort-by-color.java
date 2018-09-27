/*


https://www.interviewbit.com/problems/sort-by-color/

Sort by Color
Asked in:  
Facebook
Microsoft
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]


*/


public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        
        int n = a.size();
        int low = 0, mid = 0, high = n-1;
        
        while(mid <= high) {
            if(a.get(mid).equals(new Integer(0))) {
                Integer temp = a.get(low);
                a.set(low, a.get(mid));
                a.set(mid, temp);
                low++;
                mid++;
            } else if(a.get(mid).equals(new Integer(1))) {
                mid++;
            } else {
                Integer temp = a.get(mid);
                a.set(mid, a.get(high));
                a.set(high, temp);
                high--;
            }
        }
        
    }
}
