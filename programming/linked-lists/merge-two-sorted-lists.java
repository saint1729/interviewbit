/*


https://www.interviewbit.com/problems/merge-two-sorted-lists/


Merge Two Sorted Lists
Asked in:  
Microsoft
Yahoo
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20


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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        
        if(A == null) {
            return B;
        } else if(B == null) {
            return A;
        }
        
        ListNode C = new ListNode(0);
        ListNode temp = C;
        
        while((A != null) && (B != null)) {
            
            int aVal = A.val;
            int bVal = B.val;
            
            if(aVal < bVal) {
                ListNode newNode = new ListNode(aVal);
                temp.next = newNode;
                temp = temp.next;
                A = A.next;
            } else {
                ListNode newNode = new ListNode(bVal);
                temp.next = newNode;
                temp = temp.next;
                B = B.next;
            }
            
        }
        
        if(A == null) {
            temp.next = B;
        } else if(B == null) {
            temp.next = A;
        }
        
        return C.next;
    }
}
