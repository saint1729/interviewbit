/*



https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/




Sum Root to Leaf Numbers
Asked in:  
Google
Microsoft
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.



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

    public void sumNumbersUtil(TreeNode A, ArrayList<ArrayList<Integer>> ans,
                                ArrayList<Integer> path) {
        if(A == null) {
            return;
        }
        path.add(A.val);
        if((A.left == null) && (A.right == null)) {
            ans.add(new ArrayList<Integer>(path));
        }
        if(A.left != null) {
            sumNumbersUtil(A.left, ans, path);
        }
        if(A.right != null) {
            sumNumbersUtil(A.right, ans, path);
        }
        path.remove(path.size()-1);
    }

    public int sumNumbers(TreeNode A) {
        
        int sum = 0, p = 1003;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        sumNumbersUtil(A, ans, path);
        
        for(int i = 0; i < ans.size(); i++) {
            int num = 0;
            ArrayList<Integer> l = ans.get(i);
            for(int j = 0; j < l.size(); j++) {
                num = (num*10+l.get(j))%p;
            }
            sum = (sum+num)%p;
        }
        
        return sum;
    }
}
