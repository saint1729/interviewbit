/*



https://www.interviewbit.com/problems/distinct-numbers-in-window/




Distinct Numbers in Window
Asked in:  
Amazon
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

If K > N, return empty array.
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].




*/





public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int N = A.size();
        
        if((B < 1) || (B > N)) {
            return ans;
        }
        
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        int i = 0;
        
        for(i = 0; i < B; i++) {
            if(!m.containsKey(A.get(i))) {
                m.put(A.get(i), 1);
            } else {
                m.put(A.get(i), m.get(A.get(i))+1);
            }
        }
        
        ans.add(m.size());
        
        int k = 0;
        
        for(int j = i; j < N; j++) {
            
            if(!m.containsKey(A.get(k))) {
                m.remove(A.get(k));
            } else {
                m.put(A.get(k), m.get(A.get(k))-1);
            }
            
            if(!m.containsKey(A.get(j))) {
                m.put(A.get(j), 1);
            } else {
                m.put(A.get(j), m.get(A.get(j))+1);
            }
            
            ans.add(m.size());
            
            k += 1;
        }
        
        return ans;
    }
}
