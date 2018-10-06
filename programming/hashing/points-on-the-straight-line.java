/*


https://www.interviewbit.com/problems/points-on-the-straight-line/




Points on the Straight Line
Asked in:  
Google
Amazon
InMobi
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])



*/





public class Solution {
    
    public class Pair<A, B> {
        private A first;
        private B second;
    
        public Pair(A first, B second) {
            super();
            this.first = first;
            this.second = second;
        }
    
        public int hashCode() {
            int hashFirst = first != null ? first.hashCode() : 0;
            int hashSecond = second != null ? second.hashCode() : 0;
    
            return (hashFirst+hashSecond)*hashSecond+hashFirst;
        }
        
        public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair otherPair = (Pair) other;
                return 
                ((this.first == otherPair.first ||
                    (this.first != null && otherPair.first != null &&
                      this.first.equals(otherPair.first))) &&
                 (this.second == otherPair.second ||
                    (this.second != null && otherPair.second != null &&
                      this.second.equals(otherPair.second))));
            }
    
            return false;
        }
    
        public String toString()
        { 
               return "(" + first + ", " + second + ")"; 
        }
    
        public A getKey() {
            return first;
        }
    
        public void setKey(A first) {
            this.first = first;
        }
    
        public B getValue() {
            return second;
        }
    
        public void setValue(B second) {
            this.second = second;
        }
    }
    
    public int gcd(int a, int b) {
        if(a == 0) {
            return b;
        } else {
            return gcd(b%a, a);
        }
    }

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        
        int n = a.size();
        
        if(n < 3) {
            return n;
        }
        
        HashMap<Pair, Integer> hm = new HashMap<>();
        int overlapPointCount, verticalPointCount, diffPointCount,
                totalPointCount = 0, maxPointCount = 0;
        
        for(int i = 0; i < n; i++) {
            overlapPointCount = 1;
            verticalPointCount = 0;
            diffPointCount = 0;
            for(int j = i+1; j < n; j++) {
                Pair p1 = new Pair(a.get(i), b.get(i));
                Pair p2 = new Pair(a.get(j), b.get(j));
                if(p1.equals(p2)) {
                    overlapPointCount += 1;
                } else if(p1.getKey().equals(p2.getKey())) {
                    verticalPointCount += 1;
                } else {
                    int yDiff = (int)p2.getValue()-(int)p1.getValue();
                    int xDiff = (int)p2.getKey()-(int)p1.getKey();
                    
                    int g = gcd(yDiff, xDiff);
                    
                    yDiff /= g;
                    xDiff /= g;
                    
                    Pair p3 = new Pair(yDiff, xDiff);
                    
                    if(hm.get(p3) == null) {
                        hm.put(p3, 1);
                    } else {
                        hm.put(p3, hm.get(p3)+1);
                    }
                }
            }
            
            for(Integer c : hm.values()) {
                maxPointCount = Math.max(maxPointCount,
                                    (c+overlapPointCount));
            }
            
            maxPointCount = Math.max(maxPointCount,
                                verticalPointCount+overlapPointCount);
            
            hm.clear();
        }
        
        return maxPointCount;
    }
}
