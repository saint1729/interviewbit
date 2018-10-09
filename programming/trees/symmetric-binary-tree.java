/*



https://www.interviewbit.com/problems/symmetric-binary-tree/




Symmetric Binary Tree
Asked in:  
Amazon
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem




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

    public boolean isSymmetricUtil(TreeNode A, TreeNode B) {
        if((A == null) && (B == null)) {    // Empty Tree
            return true;
        } else if((A == null) || (B == null)) {     // One of them reaches end before the other
            return false;
        } else if(A.val != B.val) {     // Both values not equal
            return false;
        } else {    // Both values equal till here. So, traverse (left, right) and (right, left) combinations
            return isSymmetricUtil(A.left, B.right) && isSymmetricUtil(A.right, B.left);
        }
    }

    public int isSymmetric(TreeNode A) {
        
        TreeNode B = A;
        
        boolean ans = isSymmetricUtil(A, B);
        
        return (ans) ? 1 : 0;
        
    }
}
