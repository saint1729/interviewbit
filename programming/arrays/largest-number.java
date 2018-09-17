/*

https://www.interviewbit.com/problems/largest-number/


Largest Number
Asked in:  
Amazon
Goldman Sachs
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.


*/


public class Solution {
    
    public class StringComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            String s1 = (String)o1;
            String s2 = (String)o2;
            
            return (s2+s1).compareTo(s1+s2);
        }
    }
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        
        List<String> B = new ArrayList<String>();
        
        for(Integer i:A) {
            B.add(Integer.toString(i));
        }
        
        Collections.sort(B, new StringComparator());
        
        StringBuffer ans = new StringBuffer();
        
        for(String s:B) {
            if("0".equals(s) && ans.length() != 0) {
                continue;
            }
            ans.append(s);
        }
        
        return ans.toString();
    }
}
