/*

https://www.interviewbit.com/problems/add-binary-strings/

Add Binary Strings
Asked in:  
Facebook
Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.

*/

public class Solution {
    public String addBinary(String A, String B) {

        String result = ""; 
         
        int s = 0;         
 
        int i = A.length() - 1, j = B.length() - 1;
        while ((i >= 0) || (j >= 0) || (s == 1)) {
             
            s += ((i >= 0) ? A.charAt(i)-'0' : 0);
            s += ((j >= 0) ? B.charAt(j)-'0' : 0);
 
            result = (char)(s%2+'0')+result;
 
            s /= 2;
 
            i--;
            j--;
        }
         
        return result;

        
    }
}
