/*


https://www.interviewbit.com/problems/nqueens/



NQueens
Asked in:  
Qualcomm
Google
Amazon
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]



*/





public class Solution {

    public boolean isSafe(char[][] board, int rowIndex, int colIndex) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if((board[i][j] == 'Q') && ((rowIndex+colIndex == i+j) ||
                                            (rowIndex+j == colIndex+i) ||
                                            (rowIndex == i) || (colIndex == j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveNQueensUtil(char[][] board, int colIndex,
                                ArrayList<ArrayList<String>> ans) {
        
        if(colIndex == board.length) {
            ArrayList<String> solution = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                solution.add(new String(board[i]));
            }
            ans.add(solution);
            return;
        }
        
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            if(isSafe(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                solveNQueensUtil(board, colIndex+1, ans);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        if(a <= 0) {
            return ans;
        }
        
        char[][] board = new char[a][a];
        
        for(int i = 0; i < a; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solveNQueensUtil(board, 0, ans);
        
        return ans;
    }
}
