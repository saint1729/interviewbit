/*


https://www.interviewbit.com/problems/maximum-consecutive-gap/



Maximum Consecutive Gap
Asked in:  
Hunan Asset
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.


*/



public class Solution {
    
    public Integer getMaxElement(List<Integer> A) {
        Integer max = Integer.MIN_VALUE;
        for(Integer i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
        }
        return max;
    }
    
    public void countSort(List<Integer> A, Integer tenPowN) {
        
        Integer N = A.size();
        int output[] = new int[N];
        int count[] = new int[10];
        Arrays.fill(count, 0);
        
        
        
        for(Integer i = 0; i < N; i++) {
            count[(A.get(i)/tenPowN)%10]++;
        }
        
        for(Integer i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }
        
        for(Integer i = N-1; i >= 0; i--) {
            output[count[(A.get(i)/tenPowN)%10]-1] = A.get(i);
            count[(A.get(i)/tenPowN)%10]--;
        }
        
        for(Integer i = 0; i < N; i++) {
            A.set(i, output[i]);
        }
        
        return;
    }

    public void radixSort(List<Integer> A) {
        Integer m = getMaxElement(A);
        
        for(Integer i = 1; m/i > 0; i *= 10) {
            countSort(A, i);
        }
        
        
        
        return;
    }
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        
        Integer N = A.size();
        
        if(N < 2) {
            return 0;
        }
        
        List<Integer> B = new ArrayList<Integer>();
        
        for(Integer i = 0; i < N; i++) {
            B.add(A.get(i));
        }
        
        radixSort(B);
        
        Integer max = B.get(1)-B.get(0);
        
        for(Integer i = 2; i < N; i++) {
            max = Math.max(max, B.get(i)-B.get(i-1));
        }
        
        return max;
    }
}
