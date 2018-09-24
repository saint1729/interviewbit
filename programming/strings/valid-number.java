/*

https://www.interviewbit.com/problems/valid-number/


Valid Number
Asked in:  
Adobe
Please Note:
Note: It is intended for some problems to be ambiguous. You should gather all requirements up front before implementing one.

Please think of all the corner cases and clarifications yourself.

Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem


*/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isNumber(final String A) {
        
        if((A == null) || (A.equals(""))) {
            return 0;
        }
        
        String B = A.trim();
        
        if(B.equals("")) {
            return 0;
        }
        
        for(int i = 0; i < B.length(); i++) {
            if((B.charAt(i) >= '0' && B.charAt(i) <= '9') ||
            (B.charAt(i) == 'e') || (B.charAt(i) == '+') || (B.charAt(i) == '-') ||
            (B.charAt(i) == '.')) {
                continue;
            } else {
                return 0;
            }
        }
        
        if(B.charAt(0) == 'e') {
            return 0;
        }
        
        if((B.charAt(B.length()-1) == '.') || ((B.charAt(B.length()-1) == 'e')) ||
        ((B.charAt(B.length()-1) == '+')) || ((B.charAt(B.length()-1) == '-'))) {
            return 0;
        }
        
        for(int i = 1; i < B.length(); i++) {
            if(B.charAt(i) == '+' || B.charAt(i) == '-') {
                if(B.charAt(i-1) != 'e') {
                    return 0;
                }
            }
        }
        
        String[] tokens = B.split(java.util.regex.Pattern.quote("e"));
        
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].charAt(tokens[i].length()-1) == '.') {
                return 0;
            }
            int instancesOfDot = tokens[i].length() - tokens[i].replace(".", "").length();
            if(instancesOfDot > 1) {
                return 0;
            } else if((tokens.length > 1) && (i > 0) && (instancesOfDot > 0)) {
                return 0;
            }
        }
        
        return 1;

    }
}
