/*


https://www.interviewbit.com/problems/sudoku/


Sudoku
Asked in:  
Microsoft
Qualcomm
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.' 
You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]



*/





public class Solution {
    
    public class Node {
        int row;
        int col;
        Node() {
            this.row = 0;
            this.col = 0;
        }
    }
    
    public boolean dotIsPresent(ArrayList<ArrayList<Character>> a, Node node) {
        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(0).size(); j++) {
                if(a.get(i).get(j) == '.') {
                    node.row = i;
                    node.col = j;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isValidInRows(ArrayList<ArrayList<Character>> a, Node node, int digit) {
        for(int i = 0; i < 9; i++) {
            if(a.get(node.row).get(i) == digit+'0') {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidInCols(ArrayList<ArrayList<Character>> a, Node node, int digit) {
        for(int i = 0; i < 9; i++) {
            if(a.get(i).get(node.col) == digit+'0') {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidInBox(ArrayList<ArrayList<Character>> a, Node node, int digit) {
        int row = node.row-(node.row%3);
        int col = node.col-(node.col%3);
        for(int i = row; i < row+3; i++) {
            for(int j = col; j < col+3; j++) {
                if(a.get(i).get(j) == (char)(digit+'0')) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(ArrayList<ArrayList<Character>> a, Node node, int digit) {
        if(isValidInRows(a, node, digit) == false) {
            return false;
        } else if(isValidInCols(a, node, digit) == false) {
            return false;
        } else if(isValidInBox(a, node, digit) == false) {
            return false;
        }
        return true;
    }
    
    public boolean isSolvable(ArrayList<ArrayList<Character>> a) {
        Node node = new Node();
        if(dotIsPresent(a, node) == false) {
            return true;
        } else {
            int row = node.row;
            int col = node.col;
            for(int i = 1; i < 10; i++) {
                if(isValid(a, node, i)) {
                    a.get(row).set(col, (char)(i+'0'));
                    if(isSolvable(a)) {
                        return true;
                    } else {
                        a.get(row).set(col, '.');
                    }
                }
            }
            return false;
        }
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        boolean solvable = isSolvable(a);
        return;
    }
}
