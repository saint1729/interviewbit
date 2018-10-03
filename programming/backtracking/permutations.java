/*

https://www.interviewbit.com/problems/permutations/


Permutations
Asked in:  
Microsoft
Adobe
Google
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 


*/


public class Solution {

    public ArrayList<Integer> swap(ArrayList<Integer> A, int i, int j) {

        int temp = A.get(i).intValue();
        A.set(i, A.get(j).intValue());
        A.set(j, temp);
        
        return A;
    }

    public void permutations(ArrayList<Integer> A, int start, ArrayList<ArrayList<Integer>> B) {
        if(start == end) {
            B.add(new ArrayList<Integer>(A));
        } else {
            for(int i = start; i <= end; i++) {
                A = swap(A, start, i);
                permutations(A, start+1, end, B);
                A = swap(A, start, i);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        permutations(A, 0, B);
        
        return B;
    }
}
