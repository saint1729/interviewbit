/*

https://www.interviewbit.com/problems/pascal-triangle/

Pascal Triangle
Asked in:  
Google
Amazon
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/


public class Solution {
    
    public Integer factorial(Integer n) {
        Integer ans = 1;
        if((n == 0) || (n == 1)) {
            return 1;
        }
        for(Integer i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
    
    public Integer Choose(Integer n, Integer k) {
        
        if((n >= 0) && (k == 0)) {
            return 1;
        }
        
        Integer min = Math.min(k, n-k);
        Integer num = 1, i = 0, den = factorial(min);
        while(i < min) {
            num *= (n-i);
            i++;
        }
        return num/den;
    }
    
    public ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if(A <= 0) {
            return ans;
        }
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        ans.add(first);
        if(A == 1) {
            return ans;
        }

        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(1);
        second.add(1);
        ans.add(second);
        
        
        for(int i = 2; i < A; i++) {
            ArrayList<Integer> X = new ArrayList<Integer>();
            X.add(1);
            for(int j = 0; j < i-1; j++) {
                X.add(ans.get(i-1).get(j)+ans.get(i-1).get(j+1));
            }
            X.add(1);
            ans.add(X);
        }
        return ans;
    }
}
