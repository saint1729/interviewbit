/*

https://www.interviewbit.com/problems/n3-repeat-number/

N/3 Repeat Number
Asked in:  
Google
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 

*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        
        if(a.size() == 0) {
            return -1;
        } else if(a.size() == 1) {
            return a.get(0);
        }
        
        Integer first = a.get(0);
        Integer second = a.get(1);
        
        Integer c1 = 0, c2 = 0;
        
        for(Integer i = 0; i < a.size(); i++) {
            if(first.intValue() == a.get(i).intValue()) {
                c1++;
            } else if(second.intValue() == a.get(i).intValue()) {
                c2++;
            } else if(c1 == 0) {
                c1++;
                first = a.get(i).intValue();
            } else if(c2 == 0) {
                c2++;
                second = a.get(i).intValue();
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        
        for(Integer i = 0; i < a.size(); i++) {
            //System.out.println("i = " + i + " first = " + first + " a[i] = " + a.get(i));
            //System.out.println("first-a[i] = " + (first == a.get(i)));
            if(first.intValue() == a.get(i).intValue()) {
                c1++;
            } else if(second.intValue() == a.get(i).intValue()) {
                c2++;
            }
        }
        
        // System.out.println();
        // System.out.println("first = " + first + " second = " + second);
        // System.out.println("c1 = " + c1 + " c2 = " + c2);
        // System.out.println("n/3 = " + a.size()/3);
        // System.out.println("boolean = " + (c1 > a.size()/3));
        
        if(c1 > a.size()/3) {
            return first;
        }
        
        if(c2 > a.size()/3) {
            return second;
        }
        
        return -1;
    }
}
