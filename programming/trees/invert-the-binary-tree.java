/*


https://www.interviewbit.com/problems/invert-the-binary-tree/



Invert the Binary Tree
Asked in:  
Google
Given a binary tree, invert the binary tree and return it. 
Look at the example for more details.

Example : 
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4





*/



/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    public void invertTreeUtil(TreeNode A) {
        if(A == null) {
            return;
        } else if((A.left == null) && (A.right == null)) {
            return;
        } else {
            TreeNode temp = A.right;
            A.right = A.left;
            A.left = temp;
            invertTreeUtil(A.left);
            invertTreeUtil(A.right);
        }
    }
    
    public TreeNode invertTree(TreeNode A) {
        
        invertTreeUtil(A);
        
        return A;
        
    }
}
