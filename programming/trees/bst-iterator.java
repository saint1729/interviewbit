/*

https://www.interviewbit.com/problems/bst-iterator/


BST Iterator
Asked in:  
Apple
Amazon
Facebook
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity. 



*/



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
 
    Stack<TreeNode> s = new Stack<TreeNode>();
    TreeNode root;
    
    public Solution(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
 
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(s.empty()) {
            return false;
        }
        return true;
    }
 
    /** @return the next smallest number */
    public int next() {
        if(this.hasNext()) {
            TreeNode node = s.pop();
            int ans = node.val;
            node = node.right;
            while(node != null) {
                s.push(node);
                node = node.left;
            }
            return ans;
        } else {
            return -1;
        }
    }
}
 
/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */