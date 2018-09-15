/*

https://www.interviewbit.com/problems/flip/

Flip
Asked in:  
VMWare
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].

*/


public class Solution {
    public ArrayList<Integer> flip(String A) {
        
        char[] B = A.toCharArray();
        
        ArrayList<Integer> C = new ArrayList<Integer>();
        
        Integer n = B.length;
        
        for(Integer i = 0; i < n; i++) {
            Integer x = -1*(int)(B[i]-'0');
            if(x == 0) {
                C.add(1);
            } else {
                C.add(-1);
            }
            //C.add(x);
        }
        
        Integer msf = 0, meh = 0, a = 0, b = 0, s = 0;
        //Integer msf = C.get(0), meh = C.get(0), a = 0, b = 0, s = 0;
        
        Boolean found = false;
        
        
        for(Integer i = 0; i < n; i++) {
            meh = meh+C.get(i);
            if((meh > msf)) {
                msf = meh;
                a = s;
                b = i;
            }
            if(meh < 0) {
                meh = 0;
                s = i+1;
                found = false;
            }
        }
        
        if(msf < 0) {
            return new ArrayList<Integer>();
        }
        
        
        ArrayList<Integer> ans = new ArrayList<Integer>();

        ans.add(a+1);
        ans.add(b+1);
        
        return ans;
        
    }
}
