/*


https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/


Convert Sorted List to Binary Search Tree
Asked in:  
Google
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3



*/



/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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
    
    ListNode head;
    
    public int length(ListNode a) {
        if(a == null) {
            return 0;
        }
        ListNode h = a;
        int ans = 0;
        while(h != null) {
            ans += 1;
            h = h.next;
        }
        return ans;
    }
    
    public TreeNode sortedListToBSTUtil(int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start+end)/2;
        
        TreeNode left = sortedListToBSTUtil(start, mid-1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = sortedListToBSTUtil(mid+1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
        
    }
    
    public TreeNode sortedListToBST(ListNode a) {
        
        int n = length(a);
        
        head = a;
        
        TreeNode root = sortedListToBSTUtil(0, n-1);
        
        return root;
        
    }
}
