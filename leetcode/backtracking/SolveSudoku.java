/*
37. Sudoku Solver
Hard
Topics
Companies
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells
*/

class SolveSudoku {
    private static void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private static boolean backtrack(char[][] board, int row, int col) {
    	// Look for all next rows
    	for(int i=row; i<9; i++, col=0){
    		// Look for all next cols
    		for(int j=col; j<9; j++) {

    			if (board[i][j] != '.') continue;

    			// Look for all candidates (1-9) at this position
    			for(char num='1'; num<='9'; num++) {

    				// Check if num can be inserted at this position
    				if (isValid(board, i, j, num)) {
    					board[i][j] = num;
    					if (backtrack(board, i, j+1)) return true;
    					board[i][j] = '.';
    				}
    			}

    			// If none of 1-9 can be inserted at ith row and jth col, return false
    			return false;
    		}
    	}
    	return true;
    }

    private static boolean isValid(char[][] board, int currentRow, int currentCol, char currentNum) {
    	// Check if in that row, other cols don't have num already
    	for(int col=0; col<9; col++) if (board[currentRow][col] == currentNum) return false;
    	// Check if in that col, other rows don't have num already
    	for(int row=0; row<9; row++) if (board[row][currentCol] == currentNum) return false;

    	// Check if current box already has currentNum
    	int startRow = currentRow / 3;
    	int startCol = currentCol / 3;
    	for(int row=3*startRow; row<3*startRow+3; row++)
    		for(int col=3*startCol; col<3*startCol+3; col++)
    			if (board[row][col] == currentNum) return false;

    	// If above 3 conditions are met, return true
    	return true;
    }

    public static void main(String[] args) {
    	char[][] board = {	{'5','3','.','.','7','.','.','.','.'},
    						{'6','.','.','1','9','5','.','.','.'},
    						{'.','9','8','.','.','.','.','6','.'},
    						{'8','.','.','.','6','.','.','.','3'},
    						{'4','.','.','8','.','3','.','.','1'},
    						{'7','.','.','.','2','.','.','.','6'},
    						{'.','6','.','.','.','.','2','8','.'},
    						{'.','.','.','4','1','9','.','.','5'},
    						{'.','.','.','.','8','.','.','7','9'}};
    	//char[][] solved = solveSudoku(board);
    	solveSudoku(board);

    	for(int i=0; i<9; i++){
	    	for(int j=0; j<9; j++) {
	    		System.out.print(board[i][j] + " ");
	    	}
	    	System.out.println("");
    	}
    }
}