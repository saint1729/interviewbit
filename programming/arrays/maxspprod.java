/*

https://www.interviewbit.com/problems/maxspprod/

MAXSPPROD
You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j. 

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9



*/


public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        
        ArrayList<Integer> lsv = new ArrayList<Integer>();
        ArrayList<Integer> rsv = new ArrayList<Integer>();

        Stack<Integer> lsvStack = new Stack<Integer>();
        Stack<Integer> rsvStack = new Stack<Integer>();
        
        Integer N = A.size();
        
        
        for(Integer i = 0; i < N; i++) {
            lsv.add(0);
            rsv.add(0);
        }
        
        
        lsvStack.push(0);
        rsvStack.push(N-1);
        
        //System.out.print(1 + " ");
                
        for(Integer i = 1; i < N; i++) {
            while(!lsvStack.empty()) {
                if(A.get(lsvStack.peek()) > A.get(i)) {
                    lsv.set(i, lsvStack.peek());
                    break;
                } else {
                    lsvStack.pop();
                }
                //System.out.print("i = " + i + " ");
            }
            if(lsvStack.empty()) {
                lsv.set(i, 0);
            }
            lsvStack.push(i);
        }
        
        //System.out.print(2 + " ");
        
        for(Integer i = N-2; i > -1; i--) {
            while(!rsvStack.empty()) {
                if(A.get(rsvStack.peek()) > A.get(i)) {
                    rsv.set(i, rsvStack.peek());
                    break;
                } else {
                    rsvStack.pop();
                }
            }
            if(rsvStack.empty()) {
                rsv.set(i, 0);
            }
            rsvStack.push(i);
        }


        //System.out.print(3 + " ");

        
        // java.math.BigInteger maxProd = new java.math.BigInteger(0);
        
        // java.math.BigInteger MOD = new java.math.BigInteger(1000000007);
        
        // for(Integer i = 0; i < N; i++) {
        //     java.math.BigInteger b1 = new java.math.BigInteger((lsv.get(i)).mod(MOD));
        //     java.math.BigInteger b2 = new java.math.BigInteger((rsv.get(i)).mod(MOD));
        //     java.math.BigInteger prod = b1.product(b2);
        //     maxProd = maxProd.max(prod.mod(MOD));
        // }
        
        
        Long maxProd = new Long(0);
        
        Long MOD = new Long(1000000007);
        
        for(Integer i = 0; i < N; i++) {
            maxProd = Math.max(maxProd, (new Long(lsv.get(i)))*(new Long(rsv.get(i))));
        }
        

        //System.out.print(4 + " ");

        
        return (new Long(maxProd%MOD)).intValue();

    }
}
