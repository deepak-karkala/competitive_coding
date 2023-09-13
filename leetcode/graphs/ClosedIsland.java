/*
1254. Number of Closed Islands
Medium
4.3K
148
Companies
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal
4-directionally connected group of 0s and a closed island is an island totally
(all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
*/

class ClosedIsland {
	// Approach: DFS from boundary
	//		Run DFS from boundary 0s and mark those as not islands (*)
	//		Run DFS from other 0s, incrementing numClosedIsland everytime an unvisited 0 is encountered
	// Time: O(n), Space:O(n) n:Number of cells
    private static int closedIsland(int[][] grid) {
        if (grid == null || grid.length <= 1) return 0;

        int m = grid.length, n = grid[0].length;
        //Run DFS from boundary 0s and mark those as not islands (*)
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (i==0 || j==0 || i==m-1 || j==n-1) dfs(grid, i, j);
        	}
        }

        //Run DFS from other 0s, incrementing numClosedIsland everytime an unvisited 0 is encountered
        int nClosedIsland = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j] == 0) {
        			dfs(grid, i, j);
        			nClosedIsland++;
        		}
        	}
        }
        return nClosedIsland;
    }

    private static void dfs(int[][] grid, int i, int j) {
    	// Do nothing if out of bounds or if current cell is water (1)
    	if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 0) return;

    	// Mark boundary land (0) as not island
    	grid[i][j] = -1;

    	// Run DFS for all neighbouring cells
    	dfs(grid, i-1, j);
    	dfs(grid, i+1, j);
    	dfs(grid, i, j-1);
    	dfs(grid, i, j+1);
    }

    public static void main(String[] args) {
    	int[][] grid = { {1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
    	int nClosedIsland = closedIsland(grid);
    	System.out.println(nClosedIsland);
    }
}