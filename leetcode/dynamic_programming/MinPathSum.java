/*
64. Minimum Path Sum
Medium
10.8K
138
Companies
Given a m x n grid filled with non-negative numbers, find a path from top left to
bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

class MinPathSum {
    public static int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
        int[][] sum = new int[m][n];
        
        minPathSumBottomUp(grid, sum);

        return sum[m-1][n-1];
    }

    public static void minPathSumBottomUp(int[][] grid, int[][] sum) {
    	int m = grid.length;
    	int n = grid[0].length;

    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			// First row, first column
    			if (i==0 && j==0) {
    				sum[i][j] = grid[i][j];
    			// First row	
    			} else if (i==0) {
    				sum[i][j] = sum[i][j-1] + grid[i][j];	
    			// First column
    			} else if (j==0) {
    				sum[i][j] = sum[i-1][j] + grid[i][j];	
    			} else {
	    			sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
	    		}
    		}
    	}
    }

    public static int minPathSumTopDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        
        return minPathSumMemo(grid, m-1, n-1, sum);
    }

    public static int minPathSumMemo(int[][] grid, int row, int col, int[][] sum) {
        // Memoization (return sum if previously computed)
        if (sum[row][col] != 0) return sum[row][col];

        // Base cases: First row, first column
        if (row==0 && col==0) return sum[row][col] = grid[row][col];
        if (row == 0) return sum[row][col] = minPathSumMemo(grid, row, col-1, sum) + grid[row][col];
        if (col == 0) return sum[row][col] = minPathSumMemo(grid, row-1, col, sum) + grid[row][col];

        // Recursion
        return sum[row][col] = Math.min(minPathSumMemo(grid, row-1, col, sum), 
            minPathSumMemo(grid, row, col-1, sum)) + grid[row][col];
    }


    public static void main(String[] args) {
    	int[][] grid = { {1,3,1}, {1,5,1}, {4,2,1} };
    	System.out.println(minPathSumTopDown(grid));
    }
} 
