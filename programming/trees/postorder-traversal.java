/*

https://www.interviewbit.com/problems/postorder-traversal/

Postorder Traversal
Asked in:  
Amazon
Microsoft
Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(A == null) {
            return ans;
        }
        
        TreeNode current = A;
        
        // Method #1:
        
        // Stack<TreeNode> s1 = new Stack<>();
        // Stack<TreeNode> s2 = new Stack<>();
        
        // s1.push(current);
        
        // while(!s1.empty()) {
        //     TreeNode temp = s1.pop();
        //     s2.push(temp);
        //     if(temp.left != null) {
        //         s1.push(temp.left);
        //     }
        //     if(temp.right != null) {
        //         s1.push(temp.right);
        //     }
        // }
        
        // while(!s2.empty()) {
        //     ans.add(s2.pop().val);
        // }
        
        // Method #2:
        
        Stack<TreeNode> s = new Stack<>();
        
        while((current != null) || (!s.empty())) {
            if(current != null) {
                s.push(current);
                current = current.left;
            } else {
                TreeNode temp = s.peek();
                if(temp.right != null) {
                    current = temp.right;
                } else {
                    temp = s.pop();
                    ans.add(temp.val);
                    while((!s.empty()) && (temp == s.peek().right)) {
                        temp = s.pop();
                        ans.add(temp.val);
                    }
                }
            }
        }
        
        
        
        return ans;
    }
}
