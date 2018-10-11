/*




https://www.interviewbit.com/problems/shortest-unique-prefix/




Shortest Unique Prefix
Asked in:  
Google
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.



*/




public class Solution {

    class TrieNode {
            
        LinkedHashMap<Character, TrieNode> children;
        boolean endOfWord;
        int branches;
        
        public TrieNode() {
            this.children = new LinkedHashMap<>();
            this.endOfWord = false;
            this.branches = 1;
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
            } else {
                node.branches += 1;
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

    public void printTrie(TrieNode root, char[] str, int level) {
        if(root == null) {
            return;
        } else if(root.endOfWord) {
            str[level] = '\0';
            System.out.println(str);
            // sb.setLength(0);
            return;
        } else {
            for(int i = 0; i < 26; i++) {
                char c = (char)(i+'a');
                TrieNode node = root.children.get(c);
                if(node != null) {
                    str[level] = c;
                    printTrie(node, str, level+1);
                }
            }
            return;
        }
    }

    public void prefixUtil(TrieNode root, ArrayList<String> ans,
                                            StringBuilder sb, int N) {
        
        if(root == null) {
            return;
        }
        
        if(root.branches == 1) {
            ans.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < 26; i++) {
            char c = (char)(i+'a');
            TrieNode node = root.children.get(c);
            if(node != null) {
                // System.out.print(c);
                sb.append(c);
                prefixUtil(node, ans, sb, N);
                sb.setLength(sb.length()-1);
            }
        }
    }
    
    
    public ArrayList<String> prefix(ArrayList<String> A) {
        
        TrieNode root = new TrieNode();
        root.branches = 0;
        
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> ans2 = new ArrayList<>();
        
        for(String s:A) {
            insert(root, s);
        }
        
        // System.out.println(root.size());
        // char[] str = new char[20];
        // int level = 0;
        // printTrie(root, str, level);
        
        // System.out.println(root.children.keySet());
        
        // System.out.println(root.branches);
        
        // System.out.println(root.children.get('b').children.get('e').children.get('a').branches);
        
        StringBuilder sb = new StringBuilder();
        prefixUtil(root, ans, sb, 26);
        
        // System.out.println(ans);
        
        Collections.sort(ans);
        
        Collections.reverse(ans);
        
        
        
        for(int i = 0; i < ans.size(); i++) {
            for(int j = 0; j < ans.size(); j++) {
                if(A.get(i).startsWith(ans.get(j))) {
                    ans2.add(ans.get(j));
                    break;
                }
            }
        }

        return ans2;

    }
}
