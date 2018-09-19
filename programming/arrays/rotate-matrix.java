/*

https://www.interviewbit.com/problems/rotate-matrix/

Rotate Matrix
Asked in:  
Google
Facebook
Amazon
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]

*/


public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        Integer n = a.size();
        
        
        for(Integer i = 0; i <= n/2; i++) {
            Integer first = i;
            Integer last = n-i-1;
            for(Integer j = first; j < last; j++) {
                
                Integer offset = j-first;
                
                Integer top = a.get(first).get(j);
                a.get(first).set(j, a.get(last-offset).get(first));
                a.get(last-offset).set(first, a.get(last).get(last-offset));
                a.get(last).set(last-offset, a.get(j).get(last));
                a.get(j).set(last, top);
            }
        }
        
        
        //5 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
        
        // for(Integer i = 0; i < n; i++) {
        //     for(Integer j = 0; j < n; j++) {
        //         System.out.print(a.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
        
        
    }
}
