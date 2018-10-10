/*


https://www.interviewbit.com/problems/min-depth-of-binary-tree/



Min Depth of Binary Tree
Asked in:  
Facebook
Amazon
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
min depth = 2.




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
    
    public int minDepthUtil(TreeNode A) {
        
        if(A == null) {
            return 0;
        } else if((A.left == null) && (A.right == null)) {
            return 1;
        } else if(A.left == null) {
            return minDepthUtil(A.right)+1;
        } else if(A.right == null) {
            return minDepthUtil(A.left)+1;
        } else {
            int leftDepth = minDepthUtil(A.left)+1;
            int rightDepth = minDepthUtil(A.right)+1;
            return Math.min(leftDepth, rightDepth);
        }
        
    }
    
    public int minDepth(TreeNode A) {
        
        int ans = minDepthUtil(A);
        
        return ans;
        
    }
}
