/*

https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.

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
    
    public class Answer {
        int ans;
    }
    
    public int maxPathSumUtil(TreeNode A, Answer ans) {
        if(A == null) {
            return 0;
        } else if((A.left == null) && (A.right == null)) {
            ans.ans = Math.max(ans.ans, A.val);
            return A.val;
        } else {
            int leftAns = maxPathSumUtil(A.left, ans);
            int rightAns = maxPathSumUtil(A.right, ans);
            
            int maxSingle = Math.max(leftAns, rightAns);
            
            if((A.left != null) && (A.right != null)) {
                maxSingle = Math.max(Math.max(leftAns, rightAns)+A.val, A.val);
                ans.ans = Math.max(ans.ans, Math.max(maxSingle, leftAns+rightAns+A.val));
            } else if(A.left == null) {
                maxSingle = Math.max(rightAns+A.val, A.val);
                ans.ans = Math.max(ans.ans, maxSingle);
            } else if(A.right == null) {
                maxSingle = Math.max(leftAns+A.val, A.val);
                ans.ans = Math.max(ans.ans, maxSingle);
            }
            return maxSingle;
        }
    }
    
    public int maxPathSum(TreeNode A) {
        Answer ans = new Answer();
        ans.ans = Integer.MIN_VALUE;
        maxPathSumUtil(A, ans);
        return ans.ans;
    }
}
