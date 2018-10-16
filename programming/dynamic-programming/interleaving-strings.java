/*



https://www.interviewbit.com/problems/interleaving-strings/


Interleaving Strings
Asked in:  
Google
Yahoo
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example,
Given:

s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem



*/




public class Solution {
    public int isInterleave(String A, String B, String C) {
        
        int M = A.length(), N = B.length(), X = C.length();
        
        if(M+N != X) {
            return 0;
        }
        
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        char[] c = C.toCharArray();
        
        boolean[][] dp = new boolean[M+1][N+1];
        
        dp[0][0] = true;
        
        for(int i = 1; i <= M; i++) {
            if(a[i-1] == c[i-1]) {
                dp[i][0] = dp[i-1][0];
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(b[i-1] == c[i-1]) {
                dp[0][i] = dp[0][i-1];
            }
        }
        
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                boolean or = false;
                if(c[i+j-1] == a[i-1]) {
                    or = or || dp[i-1][j];
                }
                if(c[i+j-1] == b[j-1]) {
                    or = or || dp[i][j-1];
                }
                dp[i][j] = or;
            }
        }
        
        return dp[M][N] ? 1 : 0;
    }
}
