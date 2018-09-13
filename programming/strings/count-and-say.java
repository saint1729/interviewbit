/*

https://www.interviewbit.com/problems/count-and-say/

Count And Say
Asked in:  
Facebook
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

*/

public class Solution {
    public String countAndSay(int A) {
        
        if(A < 0) {
            return "1";
        } else if(A == 0) {
            return null;
        } else {
            String ans = "1";
            int i = 1;
            while(i < A) {
                StringBuilder sb = new StringBuilder();
                int count = 1;
                for(int j = 1; j < ans.length(); j++) {
                    if(ans.charAt(j) == ans.charAt(j-1)) {
                        count += 1;
                    } else {
                        sb.append(count);
                        sb.append(ans.charAt(j-1));
                        count = 1;
                    }
                }
                sb.append(count);
                sb.append(ans.charAt(ans.length()-1));
                ans = sb.toString();
                i += 1;
            }
            return ans;
        }
        
    }
}
