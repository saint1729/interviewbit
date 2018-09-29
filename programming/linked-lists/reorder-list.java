/*

https://www.interviewbit.com/problems/reorder-list/


Reorder List
Asked in:  
Amazon
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.



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
    
    public ListNode midPointPrev(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = A;
        
        while((fast != null) && (fast.next != null)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return prev;
    }
    
    public ListNode reverse(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode mergeLists(ListNode A, ListNode B) {
        ListNode temp1 = A;
        ListNode temp2 = B;
        
        while(temp1 != null) {
            ListNode temp3 = temp1.next;
            ListNode temp4 = temp2.next;
            if(temp3 != null) {
                temp1.next = temp2;
                temp1 = temp3;
                temp2.next = temp3;
                temp2 = temp4;
            } else {
                temp1.next = temp2;
                break;
            }
        }
        
        return A;
    }
    
    public void printList(ListNode A) {
        ListNode temp = A;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        return;
    }
    
    public ListNode reorderList(ListNode A) {
        
        if((A == null) || (A.next == null) || (A.next.next == null)) {
            return A;
        }
        
        ListNode firstHalfLast = midPointPrev(A);
        ListNode secondHalfFirst = firstHalfLast.next;
        
        firstHalfLast.next = null;
        secondHalfFirst = reverse(secondHalfFirst);
        
        // printList(A);
        // printList(secondHalfFirst);
        
        A = mergeLists(A, secondHalfFirst);
        
        
        
        return A;
    }
}
