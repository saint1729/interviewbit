/*


https://www.interviewbit.com/problems/rotate-list/


Rotate List
Asked in:  
Amazon
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.



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
    
    public int length(ListNode A) {
        int len = 0;
        while(A != null) {
            len += 1;
            A = A.next;
        }
        return len;
    }
    
    public ListNode rotateRight(ListNode A, int B) {
        int L = length(A);
        
        if(B%L == 0) {
            return A;
        }
        
        B = B%L;
        
        ListNode temp = A, temp2 = A, temp3;
        
        for(int i = 0; i < L-B; i++) {
            temp2 = temp;
            temp = temp.next;
        }
        
        temp3 = temp;
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = A;
        temp2.next = null;
        
        return temp3;
    }
}
