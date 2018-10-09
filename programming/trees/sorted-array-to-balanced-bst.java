/*



https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/


Sorted Array To Balanced BST
Asked in:  
VMWare
Amazon
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3





*/




/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public TreeNode sortedArrayToBSTUtil(List<Integer> a, int start, int end) {
        if(start > end) {
            return null;
        } else {
            
            int mid = (start+end)/2;
            
            TreeNode tn = new TreeNode(a.get(mid));
            
            tn.left = sortedArrayToBSTUtil(a, start, mid-1);
            tn.right = sortedArrayToBSTUtil(a, mid+1, end);
            
            return tn;
        }
    }

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        
        TreeNode root = sortedArrayToBSTUtil(a, 0, a.size()-1);
        
        return root;
        
    }
}
