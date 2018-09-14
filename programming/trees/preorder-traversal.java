/*

https://www.interviewbit.com/problems/preorder-traversal/

Preorder Traversal
Asked in:  
Amazon
Microsoft
Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

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
    
    public void preOrderTraversalUtil(TreeNode A, ArrayList<Integer> ans) {
        if(A == null) {
            return;
        } else {
            ans.add(A.val);
            preOrderTraversalUtil(A.left, ans);
            preOrderTraversalUtil(A.right, ans);
        }
    }
    
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
    
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        
        //Method #1:
        
        //preOrderTraversalUtil(A, ans);
        
        
        // Method #2:
        
        // Stack<TreeNode> s = new Stack<TreeNode>();
        
        // TreeNode curr = A;
        
        // if(A == null) {
        //     return ans;
        // }
        
        // s.push(curr);
        
        // while(!s.empty()) {
            
        //     curr = s.pop();
            
        //     ans.add(curr.val);
            
        //     if(curr.right != null) {
        //         s.push(curr.right);
        //     }
            
        //     if(curr.left != null) {
        //         s.push(curr.left);
        //     }
            
        // }
        
        
        
        
        // Method #3:
        
                
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
                    ans.add(current.val);
                    current = current.left;
                } else {
                    pred.right = null;
                    current = current.right;
                }
            }
        }
        
        
        return ans;

    }
}
