/*

https://www.interviewbit.com/problems/multiply-strings/


Multiply Strings
Asked in:  
Microsoft
Google
Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
For example, 
given strings "12", "10", your answer should be “120”.

NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ). 
We will retroactively disqualify such submissions and the submissions will incur penalties.


*/


public class Solution {
    
    public String sumStrings(String A, String B) {
        if(A.equals("") || A.equals("0")) {
            return B;
        }
        if(B.equals("") || B.equals("0")) {
            return A;
        }
        
        StringBuilder sb = new StringBuilder("");
        
        int carry = 0, min = Math.min(A.length(), B.length());
        
        for(int i = A.length()-1, j = B.length()-1; i > -1 && j > -1; i--, j--) {
            int xPlusy = ((A.charAt(i)-'0')+(B.charAt(j)-'0')+carry);
            carry = xPlusy/10;
            sb.append(xPlusy%10);
        }
        
        if(min == A.length() && min == B.length()) {
            if(carry != 0) {
                sb.append(carry);
                carry = 0;
            }
        } else if(min == A.length()) {
            for(int i = B.length()-min-1; i > -1; i--) {
                int xPlusy = ((B.charAt(i)-'0')+carry);
                carry = xPlusy/10;
                sb.append(xPlusy%10);
            }
            //System.out.println(sb.toString());
        } else {
            for(int i = A.length()-min-1; i > -1; i--) {
                int xPlusy = ((A.charAt(i)-'0')+carry);
                carry = xPlusy/10;
                sb.append(xPlusy%10);
            }
        }
        
        if(carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
    
    public StringBuilder multiplyWithDigit(String A, int x) {
        
        if(x == 0) {
            return new StringBuilder("0");
        } else if(x == 1) {
            return new StringBuilder(A);
        }
        StringBuilder sb = new StringBuilder("");
        
        int carry = 0;
        
        for(int i = A.length()-1; i > -1; i--) {
            int y = A.charAt(i)-'0';
            int xy = (x*y+carry);
            carry = xy/10;
            sb.append(xy%10);
        }
        
        if(carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse();
    }
    
    public String removeLeadingZeroes(String S) {
        int i = 0;
        for(; i < S.length(); i++) {
            if(S.charAt(i) != '0') {
                break;
            }
        }
        String sub = S.substring(i);
        if("".equals(sub)) {
            return new String("0");
        }
        return sub;
    }
    
    public String multiply(String A, String B) {
        
        String ans = "";
        
        A = removeLeadingZeroes(A);
        B = removeLeadingZeroes(B);
        
        if("0".equals(A) || "0".equals(B)) {
            return new String("0");
        }
        
        //ans = sumStrings("29498", "126420");

        for(int i = A.length()-1; i > -1; i--) {
            int x = A.charAt(i)-'0';
            StringBuilder sb = multiplyWithDigit(B, x);
            //System.out.print(x + " " + sb.toString() + " ");
            for(int j = i; j < A.length()-1; j++) {
                sb.append("0");
            }
            //System.out.println(x + " " + ans + " " + sb.toString() + " ");
            ans = sumStrings(ans, sb.toString());
        }
        
        
        return ans;
    }
}
