/*

https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/


Triplets with Sum between given range
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . 
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.


*/



public class Solution {
    
    public boolean isInFirst(Float f) {
        if((f > 0) && (f < 2.0/3.0)) {
            return true;
        }
        return false;
    }
    
    public boolean isInSecond(Float f) {
        if((f >= 2.0/3.0) && (f < 1.0)) {
            return true;
        }
        return false;
    }
    
    public boolean isInThird(Float f) {
        if((f >= 1.0) && (f < 2.0)) {
            return true;
        }
        return false;
    }
    
    public int solve(ArrayList<String> A) {
        
        if(A.size() < 3) {
            return 0;
        }
        
        ArrayList<Float> X = new ArrayList<Float>();
        for(Integer i = 0; i < A.size(); i++) {
            X.add(Float.valueOf(A.get(i)));
        }
        
        Float max1A = -1.0f*Float.MAX_VALUE, max2A = -1.0f*Float.MAX_VALUE, max3A = -1.0f*Float.MAX_VALUE, max1B = -1.0f*Float.MAX_VALUE;
        Float min1A = Float.MAX_VALUE, min2A = Float.MAX_VALUE, min1B = Float.MAX_VALUE, min2B = Float.MAX_VALUE, min1C = Float.MAX_VALUE;
        
        for(Integer i = 0; i < X.size(); i++) {
            if(max1A < X.get(i) && isInFirst(X.get(i))) {
                max3A = max2A;
                max2A = max1A;
                max1A = X.get(i);
            } else if(max2A < X.get(i) && isInFirst(X.get(i))) {
                max3A = max2A;
                max2A = X.get(i);
            } else if(max3A < X.get(i) && isInFirst(X.get(i))) {
                max3A = X.get(i);
            } else if(max1B < X.get(i) && isInSecond(X.get(i))) {
                max1B = X.get(i);
            }
            
            if(min1A > X.get(i) && isInFirst(X.get(i))) {
                min2A = min1A;
                min1A = X.get(i);
            } else if(min2A > X.get(i) && isInFirst(X.get(i))) {
                min2A = X.get(i);
            } else if(min1B > X.get(i) && isInSecond(X.get(i))) {
                min2B = min1B;
                min1B = X.get(i);
            } else if(min2B > X.get(i) && isInSecond(X.get(i))) {
                min2B = X.get(i);
            } else if(min1C > X.get(i) && isInThird(X.get(i))) {
                min1C = X.get(i);
            }
        }
        
        //System.out.print(max1A + " ");
        //System.out.print(max2A + " ");
        //System.out.print(max3A + " ");
        //System.out.print(max1B + " ");
        //System.out.print(min1A + " ");
        //System.out.print(min2A + " ");
        //System.out.print(min1B + " ");
        //System.out.print(min2B + " ");
        //System.out.print(min1C + " ");
        //System.out.print(max1A+max2A+max3A + " ");
        //System.out.print(max1A+max2A+max1B + " ");
        //System.out.print(min1A+min2A+min1B + " ");
        //System.out.print(min1A+min2A+min1C + " ");
        //System.out.print(min1A+min1B+min2B + " ");
        //System.out.print(min1A+min1B+min1C + " ");
        
        if(max1A+max2A+max3A > 1.0) {
            return 1;
        } else if((max1A+max2A+max1B > 1.0) && (max1A+max2A+max1B < 2.0)) {
            return 1;
        } else if((min1A+min2A+min1B > 1.0) && (min1A+min2A+min1B < 2.0)) {
            return 1;
        } else if(min1A+min2A+min1C < 2.0) {
            return 1;
        } else if(min1A+min1B+min2B < 2.0) {
            return 1;
        } else if(min1A+min1B+min1C < 2.0) {
            return 1;
        }
        
        return 0;
        
        
        
    }
}
