/*

https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/

Numbers of length N and value less than K
Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
Constraints:

    1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9

*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        
        Integer cDigitCount = (int)Math.log10(C)+1;
        
        if(B > cDigitCount) {
            return 0;
        } else if(B < cDigitCount) {
            Integer N = A.size();
            
            if(N == 0) {
                return 0;
            } else {
                return (((A.get(0).intValue() == 0) && (B != 1))? (N-1):N)
                            *((int)Math.pow(N, B-1));
            }
        } else {
            
            Integer ans = 0;
            Integer N = A.size();
            
            if((N == 0) || ((A.get(0).intValue() == 0) && (C == 0))) {
                return ans;
            }
            
            int minCount[] = new int[10];
            int isPresent[] = new int[10];
            Arrays.fill(minCount, 0);
            Arrays.fill(isPresent, 0);
            
            for(Integer i = 0; i < N; i++) {
                isPresent[A.get(i).intValue()] = 1;
            }
            
            for(Integer i = 1; i < 10; i++) {
                minCount[i] = minCount[i-1]+isPresent[i-1];
            }
            
            ArrayList<Integer> cDigits = new ArrayList<Integer>();
            
            for(Integer temp = C; temp > 0; temp /= 10) {
                cDigits.add(temp%10);
                //System.out.println(cDigits.get(0));
            }
            
            Collections.reverse(cDigits);
            
            for(Integer i = 0; i < cDigits.size(); i++) {
                ans += minCount[cDigits.get(i)]*((int)Math.pow(N, cDigits.size()-i-1));
                if(isPresent[cDigits.get(i)] == 0) {
                    break;
                }
            }
            
            //System.out.println("ans = " + Math.pow(N, cDigits.size()-0-1));
            
            if((isPresent[0] == 1) && (cDigits.size() != 1)) {
                ans -= ((int)Math.pow(N, cDigits.size()-1));
            }
            
            return ans;
            
        }
        
    }
}
