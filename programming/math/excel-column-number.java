/*

https://www.interviewbit.com/problems/excel-column-number/

Excel Column Number
Asked in:  
Amazon
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 

*/


public class Solution {
    public int titleToNumber(String A) {
        
        int ans = 0;
        
        for(Integer i = 0; i < A.length(); i++) {
            ans = ans*26+(A.charAt(i)-'A'+1);
        }
        
        return ans;
        
    }
}
