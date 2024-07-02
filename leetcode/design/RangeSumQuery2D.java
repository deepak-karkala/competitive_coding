/*
304. Range Sum Query 2D - Immutable
Solved
Medium
Topics
Companies
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/

class RangeSumQuery2D {
    int[][] sum;
    public RangeSumQuery2D(int[][] matrix) {
        sum = new int[matrix.length + 1][matrix[0].length + 1];

        for(int i = 1; i < matrix.length + 1; i++) {
            for(int j = 1; j < matrix[0].length + 1; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */