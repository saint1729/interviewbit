/*




https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/




Flatten Binary Tree to Linked List
Asked in:  
Adobe
Amazon
Microsoft
Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.




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
public class Solution {

    public TreeNode flatten(TreeNode a) {

        TreeNode A = a;
        while(A != null) {
            if(A.left != null) {
                TreeNode temp = A.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = A.right;
                A.right = A.left;
                A.left = null;
            }
            A = A.right;
        }

        return a;
    }
}
