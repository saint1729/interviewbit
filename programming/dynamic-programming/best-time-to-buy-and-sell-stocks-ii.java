/*



https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/





Best Time to Buy and Sell Stocks II
Asked in:  
Amazon
Facebook
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 3]
Return : 2



*/




public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if(A == null) {
            return 0;
        }
        int profit = 0;
        for(int i=1; i < A.size(); i++) {
            int diff = A.get(i)-A.get(i-1);
            if(diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
