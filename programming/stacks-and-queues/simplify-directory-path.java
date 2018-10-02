/*


https://www.interviewbit.com/problems/simplify-directory-path/



Simplify Directory Path
Asked in:  
Microsoft
Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.





*/


public class Solution {
    public String simplifyPath(String A) {
        String[] tokens = A.split("/");
        
        Stack<String> s = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals(".") || tokens[i].equals("")) {
                continue;
            } else if(tokens[i].equals("..")) {
                if(!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(tokens[i]);
            }
        }
        
        if(s.size() == 0) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // System.out.println(s.size());
        
        while(!s.empty()) {
            sb.append(new StringBuilder(s.pop()).reverse().toString());
            sb.append("/");
        }
        
        return sb.reverse().toString();
    }
}
