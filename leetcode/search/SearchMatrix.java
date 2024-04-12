/*
74. Search a 2D Matrix
Solved
Medium
Topics
Companies
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        int low = 0, high = nrows * ncols - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / ncols;
            int col = mid % ncols;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) high = mid - 1;
            else low = mid + 1;
            
        }
        return false;
    }
}