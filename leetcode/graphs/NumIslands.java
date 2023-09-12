/*
200. Number of Islands
Medium
21.2K
455
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and
'0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically. You may assume all four edges of the grid are all
surrounded by water.
*/


class NumIslands {
	// Approach: Flood filling (DFS from boundary)
    private static int numIslands_dfs(char[][] grid) {
        int numIslands = 0;
        int m=grid.length, n=grid[0].length;
		boolean[][] visited = new boolean[m][n];

		// Run DFS from each unvisited land cell (1)
		// For each cell, DFS will recursively run DFS from all neighbouring land cells
		//		and mark those cells as visited
		// So every time we encounter a new (unvisited) land cell 
		//		it means, it was previously unreachable from other land cells
		//		=> This is a new island, increment numIslands by 1.
		// Or change visited 1s to 0s or 2s to avoid using extra visited matrix 
		//		(but this will mean we are changing input array)
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j]=='1' && !visited[i][j]) {
        			dfs(grid, visited, i, j);
        			numIslands++;
        		}
        	}
        }

        return numIslands;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j){
    	// Do nothing if out of bounds or if current cell is water (0) or if current cell is already visited
    	if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != '1' || visited[i][j]) return;

    	// Mark current cell as visited
    	visited[i][j] = true;

    	// Run DFS from neighbouring cells in all 4 directions
    	dfs(grid, visited, i-1, j);
    	dfs(grid, visited, i+1, j);
    	dfs(grid, visited, i, j-1);
    	dfs(grid, visited, i, j+1);
    }

    public static void main(String[] args) {
    	char[][] grid = { {'1','1','0','0','0'},
						  {'1','1','0','0','0'},
 						  {'0','0','1','0','0'},
						  {'0','0','0','1','1'} };
    	int nIslands = numIslands_dfs(grid);
    	System.out.println(nIslands);
    }
}