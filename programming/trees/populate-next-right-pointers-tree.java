/*

https://www.interviewbit.com/problems/populate-next-right-pointers-tree/


Populate Next Right Pointers Tree
Asked in:  
Microsoft
Amazon
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
Example :

Given the following binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 Note 1: that using recursion has memory overhead and does not qualify for constant space.
Note 2: The tree need not be a perfect binary tree. 


*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if((root == null) || ((root.left == null) && (root.right == null))) {
            return;
        }
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()) {
            TreeLinkNode top = q.peek();
            q.poll();
            if(top != null) {
                top.next = q.peek();
                if(top.left != null) {
                    q.add(top.left);
                }
                if(top.right != null) {
                    q.add(top.right);
                }
            } else if(!q.isEmpty()) {
                q.add(null);
            }
        }
        
    }
}
