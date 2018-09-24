/*

https://www.interviewbit.com/problems/atoi/


Atoi
Asked in:  
Adobe
Nvidia
Agilent systems
Bloomberg
Amazon
Apple
Microsoft
Groupon
Please Note:
There are certain questions where the interviewer would intentionally frame the question vague.
The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.

Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 
Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
If you do, we will disqualify your submission retroactively and give you penalty points.


*/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        
        char c;
        int i = 0, N = A.length(), ans = 0, firstIndex = N - 1;
        boolean found = false, foundNum = false;
        int negSign = -1;
        
        
        while(i < N) {
            
            c = A.charAt(i);
            
            if(c >= '0' && c <= '9') {
                if(found == false) {
                    firstIndex = i;
                    found = true;
                }
                int num = (c-'0');
                int max = (Integer.MAX_VALUE-num)/10;
                int min = (Integer.MIN_VALUE+num)/10;
                if((ans > max) && ((firstIndex == 0) || A.charAt(0) == '+')) {
                    return Integer.MAX_VALUE;
                } else if((-1*ans < min) && (A.charAt(0) == '-')) {
                    return Integer.MIN_VALUE;
                }
                ans = ans*10 + num;
                foundNum = true;
            } else if(i > firstIndex) {
                break;
            } else if((c == '-') && (i == 0)) {
                i += 1;
                continue;
            } else if((c == '+') && (i == 0)) {
                i += 1;
                continue;
            } else {
                break;
            }
            
            i += 1;
        }
        
        if((ans > 0) && (firstIndex > 0)) {
            if(A.charAt(firstIndex-1) == '-') {
                ans = negSign*ans;
            }
        }
        
        return ans;
        
        
    }
}
