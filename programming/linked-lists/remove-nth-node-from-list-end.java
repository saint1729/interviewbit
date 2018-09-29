/*

https://www.interviewbit.com/problems/remove-nth-node-from-list-end/


Remove Nth Node from List End
Asked in:  
HCL
Amazon
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.

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
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if((A == null) || (A.next == null)) {
            return null;
        }
        
        int i = 0;
        ListNode temp = A, temp2 = A, temp3;
        temp3 = temp2;
        while((i < B) && (temp != null)) {
            temp = temp.next;
            i += 1;
        }
        
        if(temp == null) {
            return A.next;
        }
        //System.out.println("i = " + i);
        while(temp != null) {
            temp3 = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        
        temp3.next = temp2.next;

        return A;
    }
}
