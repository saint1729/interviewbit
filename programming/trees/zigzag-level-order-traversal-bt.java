/*



https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/




ZigZag Level Order Traversal BT
Asked in:  
Amazon
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example : 
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if(A == null) {
            return ans;
        }
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(A);
        
        while((!s1.empty()) || (!s2.empty())) {
            ArrayList<Integer> level1 = new ArrayList<>();
            ArrayList<Integer> level2 = new ArrayList<>();

            while(!s1.empty()) {
                TreeNode node = s1.pop();
                level1.add(node.val);
                if(node.left != null) {
                    s2.push(node.left);
                }
                if(node.right != null) {
                    s2.push(node.right);
                }
            }
            if(level1.size() != 0) {
                ans.add(level1);
            }
            while(!s2.empty()) {
                TreeNode node = s2.pop();
                level2.add(node.val);
                if(node.right != null) {
                    s1.push(node.right);
                }
                if(node.left != null) {
                    s1.push(node.left);
                }
            }
            if(level2.size() != 0) {
                ans.add(level2);
            }
            
        }
        
        return ans;
    }
}
