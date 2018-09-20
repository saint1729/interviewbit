/*

https://www.interviewbit.com/problems/sorted-permutation-rank-with-repeats/


Sorted Permutation Rank with Repeats
Asked in:  
Housing
Zenefits
Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. 
Look at the example for more details.

Example :

Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' : 
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003

 NOTE: 1000003 is a prime number
NOTE: Assume the number of characters in string < 1000003 


*/



public class Solution {
    
    public long factorial(long n, long p) {
        if(n == 0L || n == 1L) {
            return 1L;
        }
        
        n %= p;

        long ans = 1L;

        while(n > 0) {
            ans = (ans*n)%p;
            n--;
        }
        
        return ans;
    }
    
    public long exp(long x, long y, long p) {
        
        long ans = 1;
        
        x = x%p;
        
        while(y > 0) {
            if((y & 1) == 1) {
                ans = (ans*x)%p;
            }
            
            y = y >> 1;
            x = (x*x)%p;
        }
        
        return ans;
    }
    
    public int findRank(String A) {
        
        HashMap<Character, Integer> B = new HashMap<Character, Integer>();
        
        List<Integer> lower = new ArrayList<Integer>();
        
        Integer N = A.length();
        long ans = 0L, p = 1000003L;
        
        for(Integer i = 0; i < N; i++) {
            lower.add(0);
        }
        
        for(Integer i = 0; i < N-1; i++) {
            for(Integer j = i+1; j < N; j++) {
                if(A.charAt(j) < A.charAt(i)) {
                    // System.out.print(i + " " + A.charAt(i) + " " + j + " " + A.charAt(j) + "  ");
                    lower.set(i, lower.get(i)+1);
                }
            }
        }
        
        // for(Integer i = 0; i < N; i++) {
        //     System.out.println(lower.get(i));
        // }
        
        
        for(Integer i = 0; i < N; i++) {
            
            List<Integer> rightRepeats = new ArrayList<Integer>();
            
            for(Integer j = 0; j < 52; j++) {
                rightRepeats.add(0);
            }
            
            for(Integer j = i; j < N; j++) {
                if(A.charAt(j) >= 'A' && A.charAt(j) <= 'Z') {
                    Integer index = A.charAt(j)-'A';
                    //System.out.print(rightRepeats.get(index) + " ");
                    rightRepeats.set(index, rightRepeats.get(index)+1);
                    //System.out.print(rightRepeats.get(index) + " ");
                } else {
                    Integer index = A.charAt(j)-'a'+26;
                    rightRepeats.set(index, rightRepeats.get(index)+1);
                }
            }
            
            // for(Integer j = 0; j < 52; j++) {
            //     System.out.print(rightRepeats.get(j) + " ");
            // }

            // System.out.println();
            
            long prod = 1L;
            
            // for(Integer j = 0; j < rightRepeats.size(); j++) {
            //     den *= factorial(rightRepeats.get(j));
            // }
            
            //System.out.println(factorial(N-i-1) + " " + den + " ");
            
            for(Integer j = 0; j < rightRepeats.size(); j++) {
                prod = (prod*exp(factorial(rightRepeats.get(j), p), p-2, p))%p;
            }
            
            ans = (ans+((1L*lower.get(i)*factorial(N-i-1, p))%p*prod)%p)%p;
        }
        
        
        return (int)((ans+1L)%p);
    }
}
