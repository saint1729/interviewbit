/*

https://www.interviewbit.com/problems/fizzbuzz/


FizzBuzz
Given a positive integer N, print all the integers from 1 to N. But for multiples of 3 print “Fizz” instead of the number and for the multiples of 5 print “Buzz”. Also for number which are multiple of 3 and 5, prints “FizzBuzz”.

Example

N = 5
Return: [1 2 Fizz 4 Buzz]
Note: Instead of printing the answer, you have to return it as list of strings.

*/

public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        
        ArrayList<String> res = new ArrayList<String>();
        
        for(Integer i = 1; i < A+1; i++) {
            if(i%15 == 0) {
                res.add("FizzBuzz");
            } else if(i%3 == 0) {
                res.add("Fizz");
            } else if(i%5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        
        return res;
        
    }
}
