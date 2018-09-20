/*

https://www.interviewbit.com/problems/largest-coprime-divisor/


Largest Coprime Divisor
You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5

*/

public class Solution {
    
    public int gcd(int a, int b) {
        while(a != 0 && b != 0) {
            Integer c = a%b;
            a = b;
            b = c;
        }
        
        return a+b;
    }
    
    public int cpFact(int A, int B) {
        
        while(gcd(A, B) != 1) {
            A /= gcd(A, B);
        }
        
        return A;
    }
}
