/*

https://www.interviewbit.com/problems/sorted-insert-position/

Sorted Insert Position
Asked in:  
Yahoo
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        
        Integer low = 0, high = a.size()-1, pos = 0;
        
        Integer mid = (low+high)/2;
        
        while(low <= high) {
            mid = (low+high)/2;
            if(a.get(mid).equals(b)) {
                break;
            } else if(a.get(mid).compareTo(b) < 0) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return (a.get(mid).compareTo(b) < 0) ? mid+1 : mid;
    }
}
