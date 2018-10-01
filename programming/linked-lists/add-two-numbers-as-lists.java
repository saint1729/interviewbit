/*


https://www.interviewbit.com/problems/add-two-numbers-as-lists/


Add Two Numbers as Lists
Asked in:  
Amazon
Qualcomm
Microsoft
Facebook
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.


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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode C = new ListNode(-1);
        ListNode temp = C;
        int carry = 0;
        while((A != null) || (B != null)) {
            int x = (A == null) ? 0 : A.val;
            int y = (B == null) ? 0 : B.val;
            int z = (x+y+carry);
            int digit = z%10;
            carry = z/10;
            ListNode node = new ListNode(digit);
            temp.next = node;
            temp = temp.next;
            if(A != null) {
                A = A.next;
            }
            if(B != null) {
                B = B.next;
            }
        }
        
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        
        return C.next;
    }
}
