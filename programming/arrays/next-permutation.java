/*

https://www.interviewbit.com/problems/next-permutation/

Next Permutation
Asked in:  
Microsoft
Amazon
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points. 

*/

public class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        
        if(a.size() < 2) {
            return;
        }
        
        Integer targetIndex = 0;
        
        for(Integer i = a.size()-1; i > 0; i--) {
            if(a.get(i) > a.get(i-1)) {
                targetIndex = i-1;
                break;
            }
        }
        
        if(targetIndex == 0) {
            Collections.reverse(a);
            return;
        }
        
        Integer x = a.get(targetIndex);
        Integer nextNumber = x, nextIndex = targetIndex;
        
        for(Integer i = a.size()-1; i > targetIndex; i--) {
            if(a.get(i) > nextNumber) {
                Integer temp = a.get(i);
                a.set(i, x);
                a.set(targetIndex, temp);
                break;
            }
        }
        
        Collections.sort(a.subList(targetIndex+1, a.size()));
        
        //for(Integer i = 0; i < a.size(); i++) {
            //System.out.print(a.get(i) + " ");
        //}
        
        return;
    }
}
