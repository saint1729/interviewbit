/*

Vertical Order traversal of Binary Tree
Asked in:  
Amazon
Problem Setter: yashpal1995 Problem Tester: RAMBO_tejasv
Given a binary tree, print a vertical order traversal of it.

Example :
Given binary tree:

      6
    /   \
   3     7
  / \     \
 2   5     9
returns

[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]


Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

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
    
    public class Node {
        TreeNode tn;
        int hd;
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        
        
        
        Queue<Node> q = new LinkedList<Node>();
        
        Node node = new Node();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if(A == null) {
            return ans;
        }
        
        Map<Integer, ArrayList<Integer>> m =
                            new TreeMap<Integer, ArrayList<Integer>>();
        int val = A.val;
        int hd = 0;
        
        node.tn = A;
        node.hd = 0;
        
        q.add(node);
        
        while(!q.isEmpty()) {
            node = q.poll();
            TreeNode tn = node.tn;
            hd = node.hd;
            
            m.putIfAbsent(node.hd, new ArrayList<Integer>());
            m.get(node.hd).add(node.tn.val);

            if(tn.left != null) {
                Node leftNode = new Node();
                leftNode.tn = tn.left;
                leftNode.hd = hd-1;
                q.add(leftNode);
            }

            if(tn.right != null) {
                Node rightNode = new Node();
                rightNode.tn = tn.right;
                rightNode.hd = hd+1;
                q.add(rightNode);
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}
