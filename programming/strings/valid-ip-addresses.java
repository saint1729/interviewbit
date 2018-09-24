/*


https://www.interviewbit.com/problems/valid-ip-addresses/



Valid Ip Addresses
Asked in:  
Amazon
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)


*/


public class Solution {
    
    public boolean isValidIp(String s) {
        String[] tokens = s.split(java.util.regex.Pattern.quote("."));
        
        // for(int i = 0; i < tokens.length; i++) {
        //     System.out.print(tokens[i] + " ");
        // }
        
        // System.out.println();
        
        for(int i = 0; i < tokens.length; i++) {
            int x = Integer.parseInt(tokens[i]);
            if((tokens[i].length() > 3) || (x > 255)) {
                return false;
            }
            //System.out.println(tokens[i].length() + " " + tokens[i].charAt(0));
            if((tokens[i].length() > 1) &&
            (tokens[i].charAt(0) == '0')) {
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList<String> restoreIpAddresses(String A) {
        
        ArrayList<String> ans = new ArrayList<String>();
        
        if(A.length() < 4 || A.length() > 12) {
            return ans;
        }
        
        String s = A;
        
        for(int i = 1; i < A.length()-2; i++) {
            for(int j = i+1; j < A.length()-1; j++) {
                for(int k = j+1; k < A.length(); k++) {
                    s = s.substring(0, k) + "." + s.substring(k);
                    s = s.substring(0, j) + "." + s.substring(j);
                    s = s.substring(0, i) + "." + s.substring(i);
                    
                    if(isValidIp(s)) {
                        ans.add(s);
                    }
                    s = A;
                }
            }
        }
        
        
        return ans;
    }
}
