/*


https://www.interviewbit.com/problems/sort-list/



Sort List
Asked in:  
Google
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5


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
    
    public ListNode mergeSorted(ListNode A, ListNode B) {
        ListNode l = new ListNode(0);
        ListNode head = l;
        ListNode left = A, right = B;
        while((left != null) && (right !=null)) {
            if(left.val <= right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        
        if(left != null) {
            head.next = left;
        } else if(right != null) {
            head.next = right;
        }
        
        return l.next;
    }

    public ListNode leftEnd(ListNode A) {
        ListNode slow = A, fast = A;
        
        while((fast != null) && (fast.next) != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode sortList(ListNode A) {
        if((A == null) || (A.next == null)) {
            return A;
        }
        
        // ListNode slow = A, fast = A;
        
        // while((fast != null) && (fast.next != null)) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        
        // ListNode right = slow.next;
        // slow.next = null;
        
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = null;
        while((fast != null) && (fast.next != null)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        return mergeSorted(sortList(A), sortList(slow));
    }
}
