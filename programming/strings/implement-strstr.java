/*

https://www.interviewbit.com/problems/implement-strstr/


Implement StrStr
Asked in:  
Facebook
Amazon
Qualcomm
Wipro
Microsoft
Please Note:
Another question which belongs to the category of questions which are intentionally stated vaguely. 
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. 



*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        
        if(A == null || B == null || A.length() == 0 || B.length() == 0 || B.length() > A.length()) {
            return -1;
        }
        
        if((A.length() == B.length()) && !B.equals(A)) {
            return -1;
        }
        
        else {
            for(Integer i = 0; i < A.length(); i++) {
                if(i+B.length() <= A.length()) {
                    String subString = A.substring(i, i+B.length());
                    if(B.equals(subString)) {
                        return i;
                    }
                } else {
                    break;
                }
            }
            
            return -1;
        }
        
        
    }
}
