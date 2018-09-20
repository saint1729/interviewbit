/*

https://www.interviewbit.com/problems/prime-sum/

Prime Sum
Asked in:  
Epic systems
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 


*/


public class Solution {
    public ArrayList<Integer> primesum(int A) {
        
        boolean[] primes = new boolean[A+1];
        
        Arrays.fill(primes, true);
        
        primes[0] = false;
        primes[1] = false;
        
        for(Integer i = 2; i*i <= A; i++) {
            //System.out.print(i + " ");
            if(primes[i] == true) {
                for(Integer j = 2; i*j <= A; j++) {
                    primes[i*j] = false;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
                
        for(Integer i = 2; i <= A; i++) {
            if(primes[i] && primes[A-i]) {
                res.add(i);
                res.add(A-i);
                return res;
            }
        }
        
        return res;
        
    }
}
