/*


https://www.interviewbit.com/problems/list-cycle/


List Cycle
Asked in:  
Amazon
Microsoft
NetApp
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 


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
    
    public ListNode loopNode(ListNode a, ListNode b) {
        ListNode ptr1 = b, ptr2 = b;
        int i = 1;
        while(ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            i += 1;
        }
        
        ptr1 = a;
        ptr2 = a;
        int j = 0;
        while(j < i) {
            ptr2 = ptr2.next;
            j += 1;
        }
        
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1;
    }
    
    public ListNode detectCycle(ListNode a) {
        
        ListNode slow = a, fast = a;
        
        while((slow != null) && (fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                return loopNode(a, slow);
            }
            
        }
        
        return null;
    }
}
