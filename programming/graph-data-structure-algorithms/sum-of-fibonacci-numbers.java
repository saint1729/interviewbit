/*



https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/



Sum Of Fibonacci Numbers
How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2 


*/



public class Solution {
    
    public void fibonacciCalculator(List<Integer> l, int A) {
        int i = 2;
        while(true) {
            int n = l.get(i-1)+l.get(i-2);
            if(n > A) {
                return;
            }
            l.add(n);
            i++;
        }
    }
    
    public int fibsum(int A) {
        List<Integer> l = new ArrayList<>();
        
        l.add(1);
        l.add(1);
        fibonacciCalculator(l, A);
        int count = 0, index = l.size()-1;
        
        while(A > 0) {
            count += (A/l.get(index));
            A %= l.get(index);
            index -= 1;
        }
        
        return count;
    }
}
