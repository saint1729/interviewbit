/*

https://www.interviewbit.com/problems/longest-common-prefix/

Longest Common Prefix
Asked in:  
Google
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.


*/

public class Solution {
    
    public String commonString(String A, String B) {
        int m = A.length(), n = B.length(), i = 0, index = -1, min = Math.min(m, n);
        for(; i < min; i++) {
            if(A.charAt(i) == B.charAt(i)) {
                index++;
            } else {
                break;
            }
        }
        return (index == -1) ? "" : (A.substring(0, index+1));
    }
    
    public String longestCommonPrefix(ArrayList<String> A) {
        
        if(A.size() == 0) {
            return null;
        } else if(A.size() == 1) {
            return A.get(0);
        }
        
        String cs = commonString(A.get(0), A.get(1));

        for(int i = 2; i < A.size(); i++) {
            cs = commonString(cs, A.get(i));
            if(cs == "") {
                return cs;
            }
        }
        
        return cs;
        
    }
}
