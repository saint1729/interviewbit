/*



https://www.interviewbit.com/problems/identical-binary-trees/



Identical Binary Trees
Asked in:  
Amazon
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 

   1       1
  / \     / \
 2   3   2   3

Output : 
  1 or True




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
    
    public boolean isSameTreeUtil(TreeNode A, TreeNode B) {
        if((A == null) && (B == null)) {
            return true;
        } else if((A == null) || (B == null)) {
            return false;
        } else {
            return ((A.val == B.val) &&
                    (isSameTreeUtil(A.left, B.left)) &&
                    (isSameTreeUtil(A.right, B.right)));
        }
    }
    
    
    public int isSameTree(TreeNode A, TreeNode B) {
        
        return (isSameTreeUtil(A, B)) ? 1 : 0;
        
    }
}
