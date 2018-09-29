/*

https://www.interviewbit.com/problems/palindrome-list/


Palindrome List
Asked in:  
Amazon
Microsoft
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.


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
    public int lPalin(ListNode A) {
        
        if((A == null) || (A.next == null)) {
            return 1;
        }
        
        ListNode slow = A, fast = A;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHead = slow.next;
        slow.next = null;
        
        ListNode prev = null, curr = secondHead, next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        secondHead = prev;
        
        ListNode ptr1 = A, ptr2 = secondHead;
        
        while(ptr2 != null) {
            if(ptr1.val != ptr2.val) {
                return 0;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return 1;
    }
}
