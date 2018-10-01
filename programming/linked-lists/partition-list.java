/*


https://www.interviewbit.com/problems/partition-list/



Partition List
Asked in:  
Microsoft
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


*/




/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        
        if((A == null) || (A.next == null)) {
            return A;
        }
        
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        
        fakeHead1.next = A;
        
        ListNode curr = A, prev1 = fakeHead1, prev2 = fakeHead2;
        
        while(curr != null) {
            if(curr.val < B) {
                prev1 = prev1.next;
            } else {
                prev2.next = curr;
                prev1.next = curr.next;
                prev2 = prev2.next;
            }
            curr = curr.next;
        }
        
        prev2.next = null;
        
        prev1.next = fakeHead2.next;
        
        return fakeHead1.next;
    }
}
