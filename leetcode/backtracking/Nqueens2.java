/*
52. N-Queens II
Hard
Topics
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle
*/

import java.util.*;

class Nqueens2 {
    private static int totalNQueens(int n) {
        List<List<String>> lists = new ArrayList<List<String>>();
        backtrack(lists, new ArrayList<>(), n, 0);
        //for(List<String> list: lists) System.out.println(list);
        return lists.size();
    }

    private static void backtrack(List<List<String>> lists, List<String> list, int n, int row) {
    	if (row == n) {
    		lists.add(new ArrayList<String>(list));
    	} else {
    		// Try all column positions
    		for(int col = 0; col < n; col++) {
    			if (isValid(list, row, col)) {

    				char[] pos = new char[n];
    				Arrays.fill(pos, '.');
    				pos[col] = 'Q';

    				list.add(String.valueOf(pos));
    				backtrack(lists, list, n, row + 1);
    				list.remove(list.size()-1);
    			}
    		}
    	}
    	return;
    }


    private static boolean isValid(List<String> list, int currentRow, int currentCol) {
    	for(int usedRow = 0; usedRow < currentRow; usedRow++) {
    		int usedCol = list.get(usedRow).indexOf('Q');
    		if (usedCol == currentCol) return false;

    		int rowGap = currentRow - usedRow;
    		int colGap = Math.abs(currentCol - usedCol);
    		if (rowGap == colGap) return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	int n = 4;
    	System.out.println(totalNQueens(n));
    }
}