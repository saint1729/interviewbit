/*



https://www.interviewbit.com/problems/regular-expression-match/


Regular Expression Match
Asked in:  
Facebook
Microsoft
Implement wildcard pattern matching with support for '?' and '*'.

'?' : Matches any single character.
'*' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Examples :

isMatch("aa","a") -> 0
isMatch("aa","aa") -> 1
isMatch("aaa","aa") -> 0
isMatch("aa", "*") -> 1
isMatch("aa", "a*") -> 1
isMatch("ab", "?*") -> 1
isMatch("aab", "c*a*b") -> 0
Return 1/0 for this problem.



*/




public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        
        int M = A.length(), N = B.length();
        
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        
        boolean[][] dp = new boolean[M+1][N+1];
        
        dp[0][0] = true;
        
        for(int i = 1; i <= N; i++) {
            if(b[i-1] == '*') {
                dp[0][i] = dp[0][i-1];
            }
        }
        
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if((a[i-1] == b[j-1]) || (b[j-1] == '?')) {
                    dp[i][j] = dp[i-1][j-1];
                } else if(b[j-1] == '*') {
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                }
            }
        }
        
        return dp[M][N] ? 1 : 0;
    }
}
