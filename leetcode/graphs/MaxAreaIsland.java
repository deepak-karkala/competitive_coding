/*
695. Max Area of Island
Medium
9.5K
197
Companies
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
*/

class MaxAreaIsland {
	/*
	Approach: DFS from each island
		Run DFS from each new island (1), Accumulate area of current island
		Keep track of max area of all islands
	*/
    private static int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;

        int maxArea = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j] == 1) {
        			maxArea = Math.max(maxArea, dfs(grid, i, j));
        		}
        	}
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
    	if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1) return 0;

    	grid[i][j] = -1;
    	return 1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }

    public static void main(String[] args) {
    	int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
    	System.out.println(maxAreaOfIsland(grid));
    }
}