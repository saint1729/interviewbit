/*



https://www.interviewbit.com/problems/path-sum/



Path Sum
Asked in:  
Microsoft
Yahoo
Amazon
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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

    public void inorderTraversalUtil(TreeNode A, ArrayList<Integer> ans) {
        if(A == null) {
            return;
        } else {
            inorderTraversalUtil(A.left, ans);
            ans.add(A.val);
            inorderTraversalUtil(A.right, ans);
        }
    }

    public boolean hasPathSumUtil(TreeNode A, int B) {
        if(A == null) {
            return (B == 0);
        } else if((A.left == null) && (A.right == null)) {
            return ((B-A.val) == 0);
        } else {
            boolean ans = false;
            if(A.left != null) {
                ans = ans || hasPathSumUtil(A.left, B-A.val);
            }
            if(A.right != null) {
                ans = ans || hasPathSumUtil(A.right, B-A.val);
            }
            return ans;
        }
    }

    public int hasPathSum(TreeNode A, int B) {
        
        // ArrayList<Integer> l = new ArrayList<Integer>();
        
        // inorderTraversalUtil(A, l);
        
        // System.out.println(l);

        boolean ans = hasPathSumUtil(A, B);
        
        return (ans) ? 1 : 0;
        
    }
}
