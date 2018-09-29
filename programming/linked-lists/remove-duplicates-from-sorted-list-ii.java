/*

https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/

Remove Duplicates from Sorted List II
Asked in:  
Microsoft
VMWare
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.


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
    public ListNode deleteDuplicates(ListNode A) {
        
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        
        ans.next = A;
        
        ListNode head = ans;
        
        while((head.next != null) && (head.next.next != null)) {
            int val = head.next.val;
            if(head.next.next.val == val) {
                while((head.next != null) && (head.next.val == val)) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        
        return ans.next;
    }
}
