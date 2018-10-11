/*



https://www.interviewbit.com/problems/least-common-ancestor/



Least Common Ancestor
Asked in:  
Facebook
Adobe
Microsoft
Amazon
Google
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.



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
    
    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();
    
    
    public boolean findPath(TreeNode A, int B, List<Integer> path) {
        if(A == null) {
            return false;
        }
        path.add(A.val);
        if(A.val == B) {
            return true;
        } else if((A.left != null) && (findPath(A.left, B, path))) {
            return true;
        } else if((A.right != null) && (findPath(A.right, B, path))) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    
    public int lcaUtil(TreeNode A, int B, int C, List<Integer> path1, List<Integer> path2) {
        
        // System.out.println(path1);
        // System.out.println(path2);
        
        // System.out.println(C);
        
        boolean b1 = findPath(A, B, path1);
        boolean b2 = findPath(A, C, path2);
        
        // System.out.println(b1);
        // System.out.println(b2);

        if(!b1 || !b2) {
            return -1;
        }
        
        // System.out.println(path1);
        // System.out.println(path2);
        
        int i = 0;
        for(; (i < path1.size()) && (i < path2.size()); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        // System.out.println(i);
        return path1.get(i-1);
    }
    
    
    public int lca(TreeNode A, int B, int C) {
        return lcaUtil(A, B, C, path1, path2);
    }
}
