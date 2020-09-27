package dynamic_programming;

/*
 * Unique Paths
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below). The robot can only move 
 * either down or right at any point in time. The robot is trying
 * to reach the bottom-right corner of the grid (marked 'Finish'
 * in the diagram below). How many possible unique paths are there?
 */

class UniquePaths {
    public static int uniquePaths(int m, int n) {
    	// Initialise memoised matrix
    	int[][] memo = new int[m][n];
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			memo[i][j] = -1;
    		}
    	}
    	return uniquePathsRecurse(m-1, n-1, memo);
    }
    
    
    
    public static int uniquePathsRecurse(int m, int n, int[][] memo) {
    	// Base cases
    	if (m<0 || n<0) {
    		return 0;
    	}
    	if (m==0 && n==0) {
    		return 1;
    	}

    	// Return memoised value
    	//System.out.println(m + " " + n);
    	if (memo[m][n] > -1) {
    		return memo[m][n];
    	}

    	// Recursive solution
    	memo[m][n] = uniquePathsRecurse(m, n-1, memo) + uniquePathsRecurse(m-1, n, memo);
    	return memo[m][n];
    }
    
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	// Initialise memoised matrix
    	int[][] memo = new int[m][n];
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			memo[i][j] = -1;
    		}
    	}
    	return uniquePathsRecurseWithObstacles(m-1, n-1, memo, obstacleGrid);
    }

    public static int uniquePathsRecurseWithObstacles(int m, int n, int[][] memo, int[][] obstacleGrid) {
    	// Base cases
    	if (m<0 || n<0) {
    		return 0;
    	}
    	if (obstacleGrid[m][n] == 1) {
    		memo[m][n] = 0;
    		return memo[m][n];
    	}

    	if (m==0 && n==0) {
    		return 1;
    	}

    	
    	// Return memoised value
    	//System.out.println(m + " " + n);
    	if (memo[m][n] > -1) {
    		return memo[m][n];
    	}

    	// Recursive solution
    	memo[m][n] = uniquePathsRecurseWithObstacles(m, n-1, memo, obstacleGrid) +
    			uniquePathsRecurseWithObstacles(m-1, n, memo, obstacleGrid);
    	return memo[m][n];
    }
    
    public static void main(String[] args) {
    	int m = 3;
    	int n = 3;
    	int[][] obstacleGrid = {
    			{0,0,0},
    			{0,1,0},
    			{0,0,0}
    	};
    	//System.out.print(uniquePaths(m, n));
    	System.out.print(uniquePathsWithObstacles(obstacleGrid));
    }
}

