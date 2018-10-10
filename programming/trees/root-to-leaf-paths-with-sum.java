/*



https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/


Root to Leaf Paths With Sum
Asked in:  
Microsoft
Yahoo
Amazon
Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]




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

    public void pathSumUtil(TreeNode A, int B, ArrayList<ArrayList<Integer>> ans,
                            ArrayList<Integer> path) {
        if((A == null) && (B == 0)) {
            return;
        }
        
        path.add(A.val);

        if((A.left == null) && (A.right == null)) {
            if(B == A.val) {
                ans.add(new ArrayList<Integer>(path));
            }
        }
        
        if(A.left != null) {
            pathSumUtil(A.left, B-A.val, ans, path);
        }
        
        if(A.right != null) {
            pathSumUtil(A.right, B-A.val, ans, path);
        }
        
        path.remove(path.size()-1);
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        pathSumUtil(A, B, ans, path);
        
        return ans;
    }
}
