/*



https://www.interviewbit.com/problems/balanced-binary-tree/




Balanced Binary Tree
Asked in:  
Amazon
Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 



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

    class Height {
        int height = 0;
    }

    public boolean isBalancedUtil(TreeNode A, Height h) {
        if(A == null) {
            h.height = 0;
            return true;
        } else {
            Height lh = new Height();
            Height rh = new Height();
            boolean leftBalanced = isBalancedUtil(A.left, lh);
            boolean rightBalanced = isBalancedUtil(A.right, rh);
            int leftHeight = lh.height;
            int rightHeight = rh.height;
            
            h.height = Math.max(leftHeight, rightHeight)+1;
            
            if(Math.abs(leftHeight-rightHeight) > 1) {
                return false;
            } else {
                return (leftBalanced && rightBalanced);
            }
        }
    }
    
    public int isBalanced(TreeNode A) {
        
        return isBalancedUtil(A, new Height()) ? 1 : 0;
        
    }
}
