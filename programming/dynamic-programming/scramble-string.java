/*




https://www.interviewbit.com/problems/scramble-string/



Scramble String
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
 
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. Return 0/1 for this problem.






*/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String A, final String B) {
        
        int N = A.length();
        
        if(B.length() != N) {
            return 0;
        }

        if(A.equals(B)) {
            return 1;
        }
        
        boolean[][][] scramble = new boolean[N][N][N+1];
        
        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j >= 0; j--) {
                scramble[i][j][1] = (A.charAt(i) == B.charAt(j));
                for(int l = 2; (i+l <= N) && (j+l <= N); l++) {
                    for(int k = 1; k < l; k++) {
                        scramble[i][j][l] |=
                                (scramble[i][j][k] && scramble[i+k][j+k][l-k]);
                        scramble[i][j][l] |=
                                (scramble[i][j+l-k][k] && scramble[i+k][j][l-k]);
                    }
                }
            }
        }
        
        
        return scramble[0][0][N] ? 1 : 0;
    }
}
