/*
1020. Number of Enclaves
Medium
3.7K
70
Companies
You are given an m x n binary matrix grid, where 0 represents a sea cell
and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally)
land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary
of the grid in any number of moves.
*/
import java.util.*;

class NumberOfEnclaves {
	/*
	Approach: DFS from boundary
		Start from boundary cells, start DFS from each of 4-direction surrounding cells of all boundary 1s,
			and mark those as cells from which we can walk off the boundary (using different symbol)
		The remaining 1s at the end are the ones for which we cannot walk off the boundary. 
	*/
    private static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        /*
        Start from boundary cells, start DFS from each of 4-direction surrounding cells of all boundary 1s,
			and mark those as cells from which we can walk off the boundary (using different symbol)
        */
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (i==0 || j==0 || i==m-1 || j==n-1) dfs(grid, i, j);
        	}
        }

        // The remaining 1s at the end are the ones for which we cannot walk off the boundary.
        int nEnclaves = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j] == 1) nEnclaves++;
        	}
        }
        return nEnclaves;
    }

    private static void dfs(int[][] grid, int i, int j){
    	// Do nothing if i or j out of bounds or if current cell is water (0)
    	if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1) return;

    	// Mark current cell as boundary (possible to walk off the boundary)
    	grid[i][j] = -1;

    	// Run DFS in all 4 directions (recursively marking all connected 1s as boundary)
    	dfs(grid, i-1, j);
    	dfs(grid, i+1, j);
    	dfs(grid, i, j-1);
    	dfs(grid, i, j+1);
    }

    /*
	Approach: BFS from boundary
	*/
    private static int numEnclaves_bfs(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Start BFS from boundary land (1) cells
        Queue<int[]> queue = new LinkedList<int[]>();
    	for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (i==0 || j==0 || i==m-1 || j==n-1) queue.offer(new int[]{i,j});
        	}
        }

        while(!queue.isEmpty()) {
        	int[] cell = queue.poll();
        	int i=cell[0], j=cell[1];

        	// Do nothing if out of bounds or if current cell is water (0)
        	if (i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1) continue;
        	
        	// Mark as possible to walk off from boundary
        	grid[i][j] = -1;
        	
        	// Run BFS from surrounding cells
        	queue.offer(new int[] {i-1, j});
        	queue.offer(new int[] {i+1, j});
        	queue.offer(new int[] {i, j-1});
        	queue.offer(new int[] {i, j+1});
        }

        // Count remaining 1s as not possible to walk off from boundary
        int nEnclaves = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j] == 1) nEnclaves++;
        	}
        }
        return nEnclaves;
    }

    public static void main(String[] args) {
    	int[][] grid = { {0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0,0,0,0} };
    	int nEnclaves = numEnclaves_bfs(grid);
    	System.out.println(nEnclaves);
    }
}