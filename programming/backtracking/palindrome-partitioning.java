/*


https://www.interviewbit.com/problems/palindrome-partitioning/



Palindrome Partitioning
Asked in:  
Amazon
Google
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")


*/



public class Solution {

    public boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public void partitionUtil(String a, int start, ArrayList<String> l,
                                                    ArrayList<ArrayList<String>> ans) {
        
        if((a == null) || (a.length() == 0)) {
            return;
        } else if(start == a.length()) {
            ans.add(new ArrayList(l));
            return;
        } else {
            for(int i = start; i < a.length(); i++) {
                String s = a.substring(start, i+1);
                if(isPalindrome(s)) {
                    l.add(s);
                    partitionUtil(a, i+1, l, ans);
                    l.remove(l.size()-1);
                }
            }
        }
        
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        
        ArrayList<String> l = new ArrayList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        
        int start = 0;
        
        partitionUtil(a, start, l, ans);
        
        return ans;
    }
}
