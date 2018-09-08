/*

https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/

Max Rectangle in Binary Matrix
Asked in:  
Google
Microsoft
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)


*/


public class Solution {
    
    public int maxHistArea(ArrayList<Integer> l) {
        
        int maxHistArea = 0, i = 0;
        
        Stack<Integer> s = new Stack<>();
        
        for(; i < l.size();) {
            if(s.empty() || (l.get(s.peek()) <= l.get(i))) {
                s.push(i);
                i++;
            } else {
                int top = s.pop();
                int currentHistArea = l.get(top)*(s.empty() ? i : (i-s.peek()-1));
                maxHistArea = Math.max(maxHistArea, currentHistArea);
            }
        }
        
        while(!s.empty()) {
            int top = s.pop();
            int currentHistArea = l.get(top)*(s.empty() ? i : (i-s.peek()-1));
            maxHistArea = Math.max(maxHistArea, currentHistArea);
        }
        
        return maxHistArea;
    }
    
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        
        int maxRectArea = 0;
        
        if(A.size() == 0) {
            return maxRectArea;
        }
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        for(int i = 0; i < A.get(0).size(); i++) {
            l.add(A.get(0).get(i));
        }
        
        maxRectArea = maxHistArea(l);
        
        for(int i = 1; i < A.size(); i++) {
            for(int j = 0; j < A.get(0).size(); j++) {
                if(A.get(i).get(j) == 0) {
                    l.set(j, 0);
                } else {
                    l.set(j, l.get(j)+1);
                }
            }
            maxRectArea = Math.max(maxRectArea, maxHistArea(l));
        }
        
        return maxRectArea;
    }
}
