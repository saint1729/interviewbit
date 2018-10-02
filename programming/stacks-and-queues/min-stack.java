/*



https://www.interviewbit.com/problems/min-stack/




Min Stack
Asked in:  
Yahoo
Amazon
Adobe
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor. 




*/



public class Solution {

    Stack<Integer> s;
    int min;
    
    public Solution() {
        s = new Stack<Integer>();
    }
 
    public void push(int x) {
        if(s.empty()) {
            s.push(x);
            min = x;
            return;
        }
        if(x < min) {
            s.push(2*x-min);
            min = x;
        } else {
            s.push(x);
        }
    }
 
    public void pop() {
        if(s.empty()) {
            return;
        }
        int pop = s.pop();
        if(pop < min) {
            min = 2*min-pop;
        }
    }
 
    public int top() {
        if(s.empty()) {
            return -1;
        }
        int peek = s.peek();
        if(peek < min) {
            return min;
        }
        return peek;
    }
 
    public int getMin() {
        if(s.empty()) {
            return -1;
        }
        return min;
    }
}