/*



https://www.interviewbit.com/problems/colorful-number/



Colorful Number
Asked in:  
Epic systems
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1



*/



public class Solution {
    public int colorful(int A) {
        
        if(A == 1) {
            return 1;
        }
        
        Hashtable<Integer, Integer> table = new Hashtable<>();
        String s = Integer.toString(A);
        int max = s.length()-1;
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
            if(nums[i] == 1) {
                return 0;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            for(int j = 0; j <= max && i+j < nums.length; j++) {
                product *= nums[i+j];
                if(table.containsKey(product)) {
                    return 0;
                }
                else {
                    table.put(product, 1);
                }
            }
        }
        return 1;

    }
}
