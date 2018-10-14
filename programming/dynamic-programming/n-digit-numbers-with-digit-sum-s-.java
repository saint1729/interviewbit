/*



https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/




N digit numbers with digit sum S
Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

**

N = 2, S = 4 
Valid numbers are {22, 31, 13, 40} 
Hence output 4.





*/





public class Solution {
    public int solve(int A, int B) {
        
        int count[][] = new int[A+1][B+1];
        int P = 1000000007, ans = 0;
        
        count[0][0] = 1;
        
        for(int i = 1; i <= B; i++) {
            count[0][i] = 0;
        }
        
        for(int i = 1; i <= A; i++) {
            count[i][0] = 1;
        }
        
        for(int i = 1; i <= A; i++) {
            for(int j = 1; j <= B; j++) {
                int temp = 0;
                for(int k = 0; k < 10; k++) {
                    if(j >= k) {
                        temp = (temp+count[i-1][j-k])%P;
                    }
                }
                count[i][j] = temp;
            }
        }
        
        for(int i = 1; i < 10; i++) {
            if(B-i >= 0) {
                ans = (ans+count[A-1][B-i])%P;
            }
        }
        
        return ans;
    }
}
