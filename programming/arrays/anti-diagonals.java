/*

https://www.interviewbit.com/problems/anti-diagonals/

Anti Diagonals
Asked in:  
Microsoft
Adobe
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]


*/


public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Integer n = A.size();
        for(Integer i = 0; i < 2*n-1; i ++) {
            ArrayList<Integer> D = new ArrayList<Integer>();
            for(Integer j = 0; (j < i-((i+1)/n)*((i+1)%n)+1); j++) {
                Integer r = j+((i+1)/n)*((i+1)%n), c = Math.min(i, n-1)-j;
                if((r < n) && (c < n)) {
                    //System.out.println(i + " " + j + " " + r + " " + c);
                    D.add(A.get(r).get(c));
                }
            }
            ans.add(D);
        }
        return ans;
    }
}
