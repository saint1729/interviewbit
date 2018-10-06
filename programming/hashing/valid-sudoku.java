/*


https://www.interviewbit.com/problems/valid-sudoku/



Valid Sudoku
Asked in:  
Google
Amazon
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem


*/





public class Solution {
    
    public boolean isValidInRows(ArrayList<ArrayList<Character>> a) {
        for(int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(a.get(j).get(i) != '.') {
                    if(m[(int)(a.get(j).get(i)-'1')] == true) {
                        return false;
                    } else {
                        m[(int)(a.get(j).get(i)-'1')] = true;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isValidInCols(ArrayList<ArrayList<Character>> a) {
        for(int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(a.get(i).get(j) != '.') {
                    if(m[(int)(a.get(i).get(j)-'1')] == true) {
                        return false;
                    } else {
                        m[(int)(a.get(i).get(j)-'1')] = true;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isValidInBox(ArrayList<ArrayList<Character>> a) {
        for(int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for(int j = (i/3)*3; j < (i/3)*3+3; j++) {
                for(int k = (i%3)*3; k < (i%3)*3+3; k++) {
                    if(a.get(j).get(k) != '.') {
                        if(m[(int)(a.get(j).get(k)-'1')] == true) {
                            return false; 
                        } else {
                            m[(int)(a.get(j).get(k)-'1')] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isValid(ArrayList<ArrayList<Character>> a) {
        if(isValidInRows(a) == false) {
            return false;
        } else if(isValidInCols(a) == false) {
            return false;
        } else if(isValidInBox(a) == false) {
            return false;
        }
        return true;
    }
    
    public int isValidSudoku(final List<String> A) {
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < A.size(); i++) {
            ArrayList<Character> l = new ArrayList<Character>();
            for(int j = 0; j < A.get(0).length(); j++) {
                l.add(A.get(i).charAt(j));
            }
            a.add(l);
        }
        
        boolean valid = isValid(a);
        if(valid == true) {
            return 1;
        } else {
            return 0;
        }
    }
}
