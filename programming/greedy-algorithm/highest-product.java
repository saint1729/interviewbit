/*

https://www.interviewbit.com/problems/highest-product/

Highest Product
Asked in:  
Coursera
Amazon
Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer 
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000


*/


public class Solution {
    
    public int maxp3(ArrayList<Integer> A) {
        
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,
                    max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE,
                    max3 = Integer.MIN_VALUE, N = A.size();
        
        Collections.sort(A);
        
        min1 = A.get(0);
        min2 = A.get(1);
        max1 = A.get(N-1);
        max2 = A.get(N-2);
        max3 = A.get(N-3);
        
        return (max1 > 0) ? Math.max(max2*max3, min1*min2)*max1 : 
                                max1*max2*max3;
        
    }
}
