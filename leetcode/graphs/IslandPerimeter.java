/*
463. Island Perimeter
Easy
6K
296
Companies
You are given row x col grid representing a map where grid[i][j] = 1 represents land and
grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely
surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water
around the island. One cell is a square with side length 1. The grid is rectangular, width
and height don't exceed 100. Determine the perimeter of the island.
*/

class IslandPerimeter {
    private static int islandPerimeter_dfs(int[][] grid) {
    	int perimeter = 0;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if (grid[i][j] == 1) perimeter = dfs(grid, i, j, perimeter);
        	}
        }
        return perimeter;
    }

    private static int dfs(int[][] grid, int i, int j, int perimeter) {
    	// Do nothing if out of bounds or if water or if already visited
    	if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1) return perimeter;

    	// Mark as visited
    	grid[i][j] = -1;

    	if (i==0) perimeter++;
    	if (i==grid.length-1) perimeter++;
    	if (j==0) perimeter++;
    	if (j==grid[0].length-1) perimeter++;
    	if (i>=1 && grid[i-1][j]==0) perimeter++;
    	if (i<=grid.length-2 && grid[i+1][j]==0) perimeter++;
    	if (j>=1 && grid[i][j-1]==0) perimeter++;
    	if (j<=grid[0].length-2 && grid[i][j+1]==0) perimeter++;

    	perimeter = dfs(grid, i-1, j, perimeter);
    	perimeter = dfs(grid, i+1, j, perimeter);
    	perimeter = dfs(grid, i, j-1, perimeter);
    	perimeter = dfs(grid, i, j+1, perimeter);

    	return perimeter;
    }

    private static int islandPerimeter(int[][] grid) {
    	int nLand=0, nNeighbours=0;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			nLand++;
        			// Count down neighbour
        			if (i<=grid.length-2 && grid[i+1][j]==1) nNeighbours++;
        			// Count right neighbour
        			if (j<=grid[0].length-2 && grid[i][j+1]==1) nNeighbours++;
        			// Left and up neighbours are already counted by previous cells
        		}
        	}
        }
        return 4 * nLand - 2 * nNeighbours;
    }

    public static void main(String[] args) {
    	int[][] grid = { {0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0} };
    	System.out.println(islandPerimeter(grid));
    }
}