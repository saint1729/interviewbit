/*



https://www.interviewbit.com/problems/order-of-people-heights/



Order of People Heights
Asked in:  
Google
You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.



*/






public class Solution {
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < A.size(); i++) {
            int[] x = new int[2];
            x[0] = A.get(i);
            x[1] = B.get(i);
            list.add(x);
        }
        
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return b[0] - a[0];
                else return a[1] - b[1];
            }
        });
        
        
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tmp.add(list.get(i)[1], list.get(i));
        }

        for(int i = 0; i < A.size(); i++) {
            ans.add(tmp.get(i)[0]);
        }
        
        return ans;
    }
}
