/*

https://www.interviewbit.com/problems/maximum-unsorted-subarray/


Maximum Unsorted Subarray
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.

*/

public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        
        ArrayList<Integer> X = new ArrayList<Integer>();
        
        if(A.size() < 2) {
            X.add(-1);
            return X;
        }
        
        Integer counter = 1;
        for(Integer i = 1; i < A.size(); i++) {
            if(A.get(i) >= A.get(i-1)) {
                counter++;
            }
        }
        
        if(counter == A.size()) {
            X.add(-1);
            return X;
        }
        
        
        Integer min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Integer n = A.size(), minIndex = 0, maxIndex = n-1;
        
        Boolean flag = false;
        
        for(Integer i = 1; i < n; i++) {
            if(A.get(i) < A.get(i-1)) {
                flag = true;
            }
            if(flag) {
                min = Math.min(min, A.get(i));
            }
        }
        
        flag = false;
        
        for(Integer i = n-2; i >= 0; i--) {
            if(A.get(i) > A.get(i+1)) {
                flag = true;
            }
            if(flag) {
                max = Math.max(max, A.get(i));
            }
        }
        
        //System.out.print(max + " ");
        //19 1 2 3 5 6 13 15 16 17 13 13 15 17 17 17 17 17 19 19
        //20 16 6 18 17 13 6 18 16 6 15 15 18 16 13 16 16 6 18 15 15
        
        for(Integer i = 0; i < n; i++) {
            if(min < A.get(i)) {
                minIndex = i;
                break;
            }
        }
        
        for(Integer j = n-1; j >= 0; j--) {
            if(max > A.get(j)) {
                maxIndex = j;
                break;
            }
        }
        
        
        X.add(minIndex);
        X.add(maxIndex);
        
        
        return X;
        
    }
}
