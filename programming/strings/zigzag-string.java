/*


https://www.interviewbit.com/problems/zigzag-string/

Zigzag String
Asked in:  
Paypal
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.


*/


public class Solution {
    public String convert(String A, int B) {
        
        ArrayList<StringBuilder> ansList = new ArrayList<StringBuilder>();
        
        if(B == 1) {
            return A;
        }
        
        for(int i = 0; i < B; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            ansList.add(sb);
        }
        
        int row = 0;
        boolean down = true;
        
        for(int i = 0; i < A.length(); i++) {
            ansList.set(row, ansList.get(row).append(A.charAt(i)));
            if(row == (B-1)) {
                down = false;
            } else if(row == 0) {
                down = true;
            }
            if(down == true) {
                row++;
            } else {
                row--;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        ans.append("");
        
        for(int i = 0; i < B; i++) {
            ans.append(ansList.get(i).toString());
        }
          
        return ans.toString();
    }
}
