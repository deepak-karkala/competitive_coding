/*
36. Valid Sudoku
Medium
8.1K
881
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

import java.util.*;

public class ValidSudoku {

	public static boolean isValidSudokuBitVector(char[][] board) {
		// Bit vectors to save which numbers are 
		// already seen in rows, cols and boxs
		int[] rows = new int[9];
		int[] cols = new int[9];
		int[] boxs = new int[9];
		int idx = 0;

		// Iterate through every place in 9x9 board
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++) {

				// Check only if current position has a number
				if (board[i][j] != '.') {
					idx = 1 << (board[i][j] - '1');

					// Check if this row or  col or  box
					// already has the current number
					if ((rows[i] & idx)>0) return false;
					if ((cols[j] & idx)>0) return false;
					if ((boxs[3*(i/3)+j/3] & idx)>0) return false;

					// Set the corresponding bit in each of the bit vectors
					rows[i] |= idx;
					cols[j] |= idx;
					boxs[3*(i/3) + j/3] |= idx;
				}

			}
		}

        return true;
    }

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'}
						,{'6','.','.','1','9','5','.','.','.'}
						,{'.','9','8','.','.','.','.','6','.'}
						,{'8','.','.','.','6','.','.','.','3'}
						,{'4','.','.','8','.','3','.','.','1'}
						,{'7','.','.','.','2','.','.','.','6'}
						,{'.','6','.','.','.','.','2','8','.'}
						,{'.','.','.','4','1','9','.','.','5'}
						,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudokuBitVector(board));
	}
}