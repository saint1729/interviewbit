/*


https://www.interviewbit.com/problems/copy-list/



Copy List
Asked in:  
Amazon
Microsoft
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.


*/




/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> hm =
                                    new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode headTemp = head;
        
        while(headTemp != null) {
            RandomListNode temp = new RandomListNode(headTemp.label);
            hm.put(headTemp, temp);
            headTemp = headTemp.next;
        }
        
        headTemp = head;
        
        RandomListNode value = null;
        
        while(headTemp != null) {
            value = hm.get(headTemp);
            value.next = hm.get(headTemp.next);
            value.random = hm.get(headTemp.random);
            headTemp = headTemp.next;
        }
        
        value.next = null;
        
        return hm.get(head);
    }
}
