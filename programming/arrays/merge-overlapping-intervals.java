/*

https://www.interviewbit.com/problems/merge-overlapping-intervals/


Merge Overlapping Intervals
Asked in:  
Google
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.



*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        Integer N = intervals.size();
        
        Collections.sort(intervals, new Comparator<Interval>(){

                 public int compare(Interval a, Interval b){
                    if(a.start < b.start) {
                        return -1;
                    } else if(a.start == b.start) {
                        if(a.end < b.end) {
                            return -1;
                        } else {
                            return 1;
                        }
                    } else {
                        return 1;
                    }
                 }

        });
        
        
        
        // for(Integer i = 0; i < N; i++) {
        //     System.out.println(intervals.get(i).start + " " + intervals.get(i).end);
        // }
        
        for(Integer i = 0; i < intervals.size()-1; i++) {
            
            if(intervals.get(i).end < intervals.get(i+1).start) {
                continue;
            } else {
                Interval temp = new Interval();
                temp.start = intervals.get(i).start;
                temp.end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
                intervals.remove(intervals.get(i));
                intervals.remove(intervals.get(i));
                intervals.add(i, temp);
                i--;
            }
            
            //System.out.println("i = " + i + " intervals.get(i).start = " + intervals.get(i).start + " intervals.get(i).end = " + intervals.get(i).end);
            
        }
        
        return intervals;
    }
}
