/*

https://www.interviewbit.com/problems/find-duplicate-in-array/

Find Duplicate in Array
Asked in:  
Amazon
VMWare
Riverbed
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1


*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int slow =a.get(0);
        int fast = a.get(a.get(0));
        while(slow != fast) {
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        }
        
        slow = 0;
        while(slow != fast) {
            slow = a.get(slow);
            fast = a.get(fast);
        }
        return slow;
    }
}
