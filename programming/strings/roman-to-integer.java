/*

https://www.interviewbit.com/problems/roman-to-integer/


Roman To Integer
Asked in:  
Amazon
Facebook
Microsoft
Twitter
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20

*/

public class Solution {

    int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    
    public int romanToInt(String A) {
        int res = 0;
        
        for (int i=0; i < A.length(); i++) {
            int s1 = value(A.charAt(i));
 
            if (i+1 < A.length()) {
                int s2 = value(A.charAt(i+1));
 
                if (s1 >= s2) {
                    res = res + s1;
                }
                else {
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
                i++;
            }
        }

        return res;
    }
}
