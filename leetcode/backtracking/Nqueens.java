/*
51. N-Queens
Hard
9.5K
213
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard
such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.
*/

import java.util.*;

public class Nqueens {
	private static List<List<String>> nqueens(int n) {
		List<List<String>> subsets = new ArrayList<List<String>>();
		backtrack(subsets, new ArrayList<String>(), n, 0);
		return subsets;
	}

	private static void backtrack(List<List<String>> subsets, List<String> subset, int n, int row){
		if (row == n) {
			subsets.add(new ArrayList<String>(subset));
			return;
		} else {
			// Explore all columns for this row
			for(int col=0; col<n; col++){
				if (isValid(subset, row, col)) {
					
					// Add this position to subset which may be a potential solution
					char[] charr = new char[n];
					Arrays.fill(charr, '.');
					charr[col] = 'Q';
					String s = new String(charr);
					subset.add(s);

					/*
					StringBuilder sb = new StringBuilder(n);
					for(int x=0; x<n; x++) {
						if (x==col)	sb.insert(x, 'Q');
						else sb.insert(x, '.');
					}
					subset.add(sb.toString());
					*/

					// Backtrack for next row
					backtrack(subsets, subset, n, row+1);
					subset.remove(subset.size()-1);
				}
			}
		}
		return;
	}

	private static boolean isValid(List<String> subset, int currentRow, int currentCol){
		for(int usedRow=0; usedRow<currentRow; usedRow++){
			int usedCol = subset.get(usedRow).indexOf('Q');
			// This column has already been occupied in one of the previous rows
			if (currentCol == usedCol) return false;

			// Check diagonals
			int colGap = Math.abs(currentCol - usedCol);
			int rowGap = currentRow - usedRow;
			if (colGap == rowGap) return false;
		}
		return true;
	}


	public static void main(String[] args) {
		System.out.println(nqueens(4));
	}
}