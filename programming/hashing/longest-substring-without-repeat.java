/*


https://www.interviewbit.com/problems/longest-substring-without-repeat/




Longest Substring Without Repeat
Asked in:  
Amazon
Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.




*/




public class Solution {
    public int lengthOfLongestSubstring(String A) {
        
        if((A == null) || (A == "")) {
            return 0;
        }
        
        
        int[] visited = new int[256];
        
        Arrays.fill(visited, -1);

        int currLength = 1;
        int maxLength = 1;
        
        visited[A.charAt(0)] = 0;
        
        for(int i = 1; i < A.length(); i++) {
            
            int index = visited[A.charAt(i)];
            
            if((index == -1) || (index < (i-currLength))) {
                currLength += 1;
            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength = i-index;
            }
            visited[A.charAt(i)] = i;
        }
        maxLength = Math.max(currLength, maxLength);
        
        return maxLength;
    }
}
