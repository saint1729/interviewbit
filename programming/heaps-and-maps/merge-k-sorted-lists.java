/*



https://www.interviewbit.com/problems/merge-k-sorted-lists/



Merge K Sorted Lists
Asked in:  
Flipkart
Amazon
Google
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20




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
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {  
    
                public int compare(ListNode w1, ListNode w2) {                         
                    return w1.val-w2.val;  
                }      
            }  
            );
        
        for(int i = 0; i < a.size(); i++) {
            pq.add(a.get(i));
        }
        
        ListNode head = null;
        ListNode temp = head;
        
        while(!pq.isEmpty()) {
            
            ListNode node = pq.poll();
            
            if(node.next != null) {
                pq.add(node.next);
            }
            
            if(head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            
        }
        
        return head;
    }
}
