/*

https://www.interviewbit.com/problems/rotated-sorted-array-search/

Rotated Sorted Array Search
Asked in:  
Facebook
Google
Microsoft
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*


*/


public class Solution {
    
    
    public Integer findIndex(List<Integer> A) {
        Integer low = 0, high = A.size()-1, mid, N = A.size();
        
        while(low <= high) {
            mid = (low+high)/2;
            if(A.get(low).compareTo(A.get(high)) <= 0) {
                return low;
            }
            Integer next = (mid+1)%N;
            Integer prev = (mid+N-1)%N;
            if((A.get(mid) <= A.get(next)) && (A.get(mid) <= A.get(prev))) {
                return mid;
            }
            if(A.get(mid) <= A.get(high)) {
                high = mid-1;
            } else if(A.get(mid) >= A.get(low)) {
                low = mid+1;
            }
        }
        
        return -1;
        
    }


    public int binarySearch(List<Integer> A, int B, int a, int b) {
        
        int low = a, high = b-1, index = -1;
        
        while(low <= high) {
            Integer mid = (low+high)/2;
            
            if(A.get(mid) == B) {
                return mid;
            } else if(A.get(mid) < B) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return index;
        
    }

    
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        
        
        Integer N = a.size();
        
        Integer start = 0, end = N-1;
        
        Integer index = findIndex(a);
        
        if(index == -1) {
            return -1;
        }
        
        // System.out.print(index + " ");
        
        Integer ans1 = binarySearch(a, b, 0, index+1);
        Integer ans2 = binarySearch(a, b, index, N);

        if(ans1 != -1) {
            return ans1;
        } else {
            return ans2;
        }

    }
}
