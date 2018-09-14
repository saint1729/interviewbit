/*

https://www.interviewbit.com/problems/inorder-traversal/

Inorder Traversal
Asked in:  
Amazon
Microsoft
Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.


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

    
    public void inorderTraversalUtil(TreeNode A, ArrayList<Integer> ans) {
        if(A == null) {
            return;
        } else {
            inorderTraversalUtil(A.left, ans);
            ans.add(A.val);
            inorderTraversalUtil(A.right, ans);
        }
    }

    
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        //inorderTraversalUtil(A, ans);
        
        if(A == null) {
            return ans;
        }
        
        
        TreeNode current = A;
        
        while(current != null) {
            if(current.left == null) {
                ans.add(current.val);
                current = current.right;
            } else {
                TreeNode pred = current.left;
                while((pred.right != null) && (pred.right != current)) {
                    pred = pred.right;
                }
                if(pred.right == null) {
                    pred.right = current;
                    current = current.left;
                } else {
                    pred.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }
        
        
        return ans;
        
    }
}
