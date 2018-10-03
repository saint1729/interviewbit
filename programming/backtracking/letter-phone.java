/*


https://www.interviewbit.com/problems/letter-phone/


Letter Phone
Asked in:  
Facebook
Epic systems
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.




*/




public class Solution {


    public void letterCombinationsUtil(String A, HashMap<Integer, String> hm,
                                ArrayList<Character> l, ArrayList<String> ans) {
        
        if(A.length() == 0) {
            char[] cArr = new char[l.size()];
            for(int i = 0; i < l.size(); i++) {
                cArr[i] = l.get(i);
            }
            ans.add(String.valueOf(cArr));
            return;
        } else {
            Integer current = Integer.parseInt(A.substring(0,1));
            String s = hm.get(current);
            for(int i = 0; i < s.length(); i++) {
                l.add(s.charAt(i));
                letterCombinationsUtil(A.substring(1), hm, l, ans);
                l.remove(l.size()-1);
            }
            return;
        }
        
    }


    public ArrayList<String> letterCombinations(String A) {
        
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        
        hm.put(0, "0");
        hm.put(1, "1");
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");
        
        ArrayList<String> ans = new ArrayList<String>();
        
        if((A == null) || (A.length() == 0)) {
            return ans;
        }
        
        ArrayList<Character> l = new ArrayList<Character>();
        
        letterCombinationsUtil(A, hm, l, ans);
        
        return ans;
    }
}
