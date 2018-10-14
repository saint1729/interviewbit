/*



https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/



Best Time to Buy and Sell Stocks III
Asked in:  
Amazon
Facebook
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation : 
  Day 1 : Buy 
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell




*/




public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        
        int n = A.size();
        
        if((A == null) || (n == 0)) {
            return 0;
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        int min = A.get(0), max = A.get(n-1);
        
        left[0] = 0;
        right[n-1] = 0;
        for(int i = 1; i < n; i++) {
            min = Math.min(min, A.get(i));
            left[i] = Math.max(left[i-1], A.get(i)-min);
        }
        
        for(int i = n-2; i > -1; i--) {
            max = Math.max(max, A.get(i));
            right[i] = Math.max(right[i+1], max-A.get(i));
        }
        
        int profit = 0;
        for(int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i]+right[i]);
        }
        
        return profit;
    }
}
