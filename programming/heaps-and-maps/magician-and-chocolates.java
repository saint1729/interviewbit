/*



https://www.interviewbit.com/problems/magician-and-chocolates/



Magician and Chocolates
Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7



*/



public class Solution {
    
    public int nchoc(int A, ArrayList<Integer> B) {
        
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < B.size(); i++) {
            p.add(B.get(i));
        }
        
        long n = 0, mod = (long)Math.pow(10, 9)+7;

        while(A-- > 0) {
            int v = p.poll();
            n = (n+v)%mod;
            p.add(v/2);
        }
        
        return (int)n;
    }
}
