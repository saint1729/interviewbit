/*


https://www.interviewbit.com/problems/hotel-reviews/


Hotel Reviews
Asked in:  
Booking.com
Problem Setter: ishubansal Problem Tester: raghav_aggiwal
Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]


*/




public class Solution {
    
    class TrieNode {
            
        Map<Character, TrieNode> children;
        boolean endOfWord;
        
        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
        
    }
    
    public void insert(TrieNode root, String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        
        current.endOfWord = true;
    }
    
    public boolean search(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null) {
                return false;
            }
            current = node;
        }
        
        return current.endOfWord == true;
    }
    
    public void delete(TrieNode root, String word) {
        delete(root, word, 0);
    }
    
    public boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()) {
            if(current.endOfWord != true) {
                return false;
            }
            current.endOfWord = false;
            
            return current.children.size() == 0;
        }
        
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if(node == null) {
            return false;
        }
        
        boolean deleteNode = delete(node, word, index+1);
        
        if(deleteNode == true) {
            current.children.remove(c);
            return current.children.size() == 0;
        }
        
        return false;
    }
    
    
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        
        TrieNode root = new TrieNode();
        
        String[] goodWordTokens = A.split("_");
        
        for(int i = 0; i < goodWordTokens.length; i++) {
            insert(root, goodWordTokens[i]);
        }
        
        ArrayList<Integer> ansTemp = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < B.size(); i++) {
            String review = B.get(i);
            String[] reviewTokens = review.split("_");
            int count = 0;
            for(int j = 0; j < reviewTokens.length; j++) {
                if(search(root, reviewTokens[j]) == true) {
                    count += 1;
                }
            }
            ansTemp.add(count);
            ans.add(i);
        }
        
        Collections.sort(ans, new Comparator<Integer>() {
                        public int compare(Integer i, Integer j) {
                            return ansTemp.get(j).compareTo(ansTemp.get(i));
                        }
                    });
        
        return ans;
    }
}
