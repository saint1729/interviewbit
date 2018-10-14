/*



https://www.interviewbit.com/problems/evaluate-expression-to-true/




Evaluate Expression To True
Asked in:  
Amazon
Given expression with operands and operators (OR , AND , XOR) , in how many ways can you evaluate the expression to true, by grouping in different ways? Operands are only true and false.
Input:

string :  T|F&T^T
here '|' will represent or operator 
     '&' will represent and operator
     '^' will represent xor operator
     'T' will represent true operand
     'F' will false
Output:

different ways % MOD
where MOD = 1003
Example:

string : T|F
only 1 way (T|F) => T
so output will be 1 % MOD = 1



*/



public class Solution {
    public int cnttrue(String A) {
        
        ArrayList<Character> X = new ArrayList<>();
        ArrayList<Character> Y = new ArrayList<>();
        
        for(int i = 0; i < A.length(); i++) {
            if((i%2) == 0) {
                X.add(A.charAt(i));
            } else {
                Y.add(A.charAt(i));
            }
        }
        
        int N = X.size(), MOD = 1003;
        
        int T[][] = new int[N][N];
        int F[][] = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            T[i][i] = (X.get(i) == 'T') ? 1 : 0;
            F[i][i] = (X.get(i) == 'F') ? 1 : 0;
        }
        
        for(int width = 1; width < N; width++) {
            for(int i = 0, j = width; j < N; i++, j++) {
                // T[i][j] = F[i][j] = 0;
                for(int k = i; k < (i+width); k++) {
                    int Totalik = T[i][k]+F[i][k];
                    int Totalk1j = T[k+1][j]+F[k+1][j];
                    
                    if(Y.get(k) == '&') {
                        T[i][j] = (T[i][j]+T[i][k]*T[k+1][j])%MOD;
                        F[i][j] = (F[i][j]+Totalik*Totalk1j-T[i][k]*T[k+1][j])%MOD;
                    } else if(Y.get(k) == '|') {
                        F[i][j] = (F[i][j]+F[i][k]*F[k+1][j])%MOD;
                        T[i][j] = (T[i][j]+Totalik*Totalk1j-F[i][k]*F[k+1][j])%MOD;
                    } else if(Y.get(k) == '^') {
                        T[i][j] = (T[i][j]+T[i][k]*F[k+1][j]+F[i][k]*T[k+1][j])%MOD;
                        F[i][j] = (F[i][j]+T[i][k]*T[k+1][j]+F[i][k]*F[k+1][j])%MOD;
                    }
                }
            }
        }
        
        return T[0][N-1]%MOD;
    }
}
