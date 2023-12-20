/*
240. Search a 2D Matrix II
Medium
Topics
Companies
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

class SearchMatrixII {
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        int rowIdx = 0;
        int colIdx = ncols - 1;

        while(rowIdx < nrows && colIdx >= 0) {
        	int val = matrix[rowIdx][colIdx];
        	if (val == target) {
        		return true;
        	} else if (val > target) {
        		colIdx--;
        	} else {
        		rowIdx++;
        	}
        }

        return false;
    }

    public static void main(String[] args) {
    	int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    	int target = 5;
    	System.out.println(searchMatrix(matrix, target));
    }
}