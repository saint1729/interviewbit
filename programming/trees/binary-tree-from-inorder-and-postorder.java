/*


https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/



Binary Tree From Inorder And Postorder
Asked in:  
Amazon
Microsoft
Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

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
    
    public TreeNode buildTreeUtil(ArrayList<Integer> A, int inStart, int inEnd,
                                    ArrayList<Integer> B, int postStart, int postEnd) {
        
        if(inStart > inEnd) {
            return null;
        } else {
            TreeNode node = new TreeNode(B.get(postEnd));
            if (inStart == inEnd) {
                return node;
            }
            int inIndex = search(A, inStart, inEnd, node.val);
            
            node.left = buildTreeUtil(A, inStart, inIndex-1, B,
                                    postStart, postStart+inIndex-inStart-1);
            node.right = buildTreeUtil(A, inIndex+1, inEnd, B, 
                                    postStart+inIndex-inStart, postEnd-1);
            
            return node;
        }
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        return buildTreeUtil(A, 0, A.size()-1, B, 0, B.size()-1);
        
    }
}
