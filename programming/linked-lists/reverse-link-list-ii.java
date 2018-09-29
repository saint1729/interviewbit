/*


https://www.interviewbit.com/problems/reverse-link-list-ii/


Reverse Link List II
Asked in:  
Facebook
Microsoft
Amazon
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question. 



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
    
    public void printList(ListNode A) {
        
        ListNode temp = A;
        
        if(temp == null) {
            System.out.println("List is empty");
        }
        
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
        
        return;
    }

    public ListNode reverseList(ListNode A) {
        ListNode prev = null, curr = A, next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public ListNode reverseBetween(ListNode A, int B, int C) {
        
        ListNode startPrev = null, start = null;
        ListNode end = null, endNext = null;
        
        ListNode curr = A;
        
        int i = 1;
        
        while((curr != null) && (i <= C)) {
            if(i < B) {
                startPrev = curr;
            }
            if(i == B) {
                start = curr;
            }
            if(i == C) {
                end = curr;
                endNext = curr.next;
            }
            
            curr = curr.next;
            i += 1;
        }
        end.next = null;
        
        end = reverseList(start);
        
        if(startPrev != null) {
            startPrev.next = end;
        } else {
            A = end;
        }
        
        start.next = endNext;
        
        return A;
    }
}
