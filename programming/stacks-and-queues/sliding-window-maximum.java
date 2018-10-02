/*



https://www.interviewbit.com/problems/sliding-window-maximum/



Sliding Window Maximum
Asked in:  
Google
Chronus
Walmart labs
A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. 

 
 
*/


public class Solution {
    
    
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        
        ArrayList<Integer> C = new ArrayList<Integer>();
        Deque<Integer> q = new LinkedList<Integer>();
        // Deque<Integer> q2 = new LinkedList<Integer>();
        
        
        for(int i = 0; i < B; i++) {
            // System.out.println(q2);
            while((!q.isEmpty()) &&
                    (A.get(i).compareTo(A.get(q.peekLast())) >= 0)) {
                q.removeLast();
                // q2.removeLast();
            }
            q.addLast(i);
            // q2.addLast(A.get(i));
        }
        
        for(int i = B; i < A.size(); i++) {
            // System.out.println(q2);
            C.add(A.get(q.peekFirst()));
            if((!q.isEmpty()) &&
                (q.peekFirst().compareTo(i-B) <= 0)) {
                q.removeFirst();    
                // q2.removeFirst();
            }
            while((!q.isEmpty()) &&
                    (A.get(i).compareTo(A.get(q.peekLast())) >= 0)) {
                q.removeLast();
                // q2.removeLast();
            }
            q.addLast(i);
            // q2.addLast(A.get(i));
        }

        C.add(A.get(q.peekFirst()));

        return C;

    }
}
