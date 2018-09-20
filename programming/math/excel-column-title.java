/*

https://www.interviewbit.com/problems/excel-column-title/


Excel Column Title
Asked in:  
Amazon
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 


*/


public class Solution {
    public String convertToTitle(int A) {
        
        if(A == 1) {
            return "A";
        }
        
        StringBuffer sb = new StringBuffer("");
        while(A > 0) {
            A--;
            Integer mod = A%26+1;
            sb.append("" + (char)(mod+64));
            A /= 26;
        }
        
        
        return sb.reverse().toString();
    }
}
