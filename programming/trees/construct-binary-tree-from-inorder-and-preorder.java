/*

Construct Binary Tree From Inorder And Preorder
Asked in:  
Amazon
Microsoft
Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3


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
    
    public int search(ArrayList<Integer> X, int start, int end, int val) {
        for(int i = start; i <= end; i++) {
            if(X.get(i).equals(val)) {
                return i;
            }
        }
        return -1;
    }
    
    public TreeNode buildTreeUtil(ArrayList<Integer> A, int preIndex,
                                        ArrayList<Integer> B, int inStart, int inEnd) {
        
        if(inStart > inEnd) {
            return null;
        } else {
            TreeNode node = new TreeNode(A.get(preIndex));
            if (inStart == inEnd) {
                return node;
            }
            int inIndex = search(B, inStart, inEnd, node.val);
            
            node.left = buildTreeUtil(A, preIndex+1, B, inStart, inIndex-1);
            node.right = buildTreeUtil(A, preIndex+inIndex-inStart+1,
                                    B, inIndex+1, inEnd);
            
            return node;
        }
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        return buildTreeUtil(A, 0, B, 0, B.size()-1);
        
    }
}
