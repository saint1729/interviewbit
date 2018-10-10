/*



https://www.interviewbit.com/problems/max-depth-of-binary-tree/



Max Depth of Binary Tree
Asked in:  
Goldman Sachs
Facebook
Bloomberg
Microsoft
Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
max depth = 2.





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
    public int maxDepth(TreeNode A) {
        if(A == null) {
            return 0;
        }
        else {
            int lDepth = maxDepth(A.left);
            int rDepth = maxDepth(A.right);
  
            if(lDepth > rDepth) {
                return (lDepth+1);
            } else {
                return (rDepth+1);
            }
        }
    }
}
