/*


https://www.interviewbit.com/problems/substring-concatenation/


Substring Concatenation
Asked in:  
Facebook
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).



*/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        
        ArrayList<Integer> indices = new ArrayList<Integer>();
        
        if((B == null) || (B.size() == 0)) {
            return indices;
        }
        
        int wordSize = B.get(0).length();
        int noOfWords = B.size();
        
        int totalChars = wordSize*noOfWords;
        
        if(totalChars > A.length()) {
            return indices;
        }
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String s : B) {
            if(hm.get(s) == null) {
                hm.put(s, 1);
            } else {
                hm.put(s, hm.get(s)+1);
            }
        }
        
        
        for(int i = 0; i < A.length()-totalChars+1; i++) {
            HashMap<String, Integer> hm2 = new HashMap<>();
            hm2 = (HashMap)hm.clone();
            for(int j = i; j < i+totalChars; j += wordSize) {
                String word = A.substring(j, j+wordSize);
                if(!hm.containsKey(word)) {
                    break;
                } else {
                    int x = hm2.get(word);
                    if(x > 0) {
                        hm2.put(word, x-1);
                    } else {
                        break;
                    }
                }
            }
            
            boolean flag = true;
            for(Integer c : hm2.values()) {
                // System.out.println(c);
                if(c > 0) {
                    flag = false;
                    break;
                }
            }
            
            // System.out.println(flag);
            
            if(flag) {
                indices.add(i);
            }
        }
        
        return indices;
    }
}
