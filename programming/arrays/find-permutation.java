/*

https://www.interviewbit.com/problems/find-permutation/

Find Permutation
Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]


*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        
        if((A.length() != B-1) || (B == 1)) {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Integer min = 1, max = B, i = 0;
        
        for(; i < B-1; i++) {
            if(A.charAt(i) == 'I') {
                ans.add(min++);
            } else {
                ans.add(max--);
            }
        }
        
        if(A.charAt(i-1) == 'I') {
            ans.add(min++);
        } else {
            ans.add(max--);
        }
    
        
        
        return ans;
    }
}
