/*
1034. Coloring A Border
Medium
661
840
Companies
You are given an m x n integer matrix grid, and three integers row, col, and color.
Each value in the grid represents the color of the grid square at that location.

Two squares are called adjacent if they are next to each other in any of the 4 directions.

Two squares belong to the same connected component if they have the same color and they are adjacent.

The border of a connected component is all the squares in the connected component that are
either adjacent to (at least) a square not in the component, or on the boundary of the grid
(the first or last row or column).

You should color the border of the connected component that contains the square grid[row][col]
with color.

Return the final grid.
*/

class ColorBorder {
	// Approach: DFS from given cell
	//		Run DFS from current cell and recursively from neighbouring cells
	//		For each cell, change color to 'color' if it is on boundary or if has
	//			at least one neighbour with different color (not part of connected component)
    private static int[][] colorBorder(int[][] grid, int row, int col, int color) {
		if (grid == null) return grid;

		int m=grid.length, n=grid[0].length;
		boolean[][] visited = new boolean[m][n];

		int currColor = grid[row][col];
		dfs(grid, row, col, color, currColor, visited);
		return grid;
    }

    private static void dfs(int[][] grid, int i, int j, int newColor, int currColor, boolean[][] visited) {
    	if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=currColor || grid[i][j]==newColor || visited[i][j]) return;

    	// Mark current cell as visited
    	visited[i][j] = true;

    	// Check if current cell is border (adjacent to cell not part of connected component)
    	boolean isBorder = false;
    	if (i>=1 && grid[i-1][j]!=currColor) isBorder = true;
    	else if (i<=grid.length-2 && grid[i+1][j]!=currColor) isBorder = true;
    	else if (j>=1 && grid[i][j-1]!=currColor) isBorder = true;
    	else if (j<=grid[0].length-2 && grid[i][j+1]!=currColor) isBorder = true;

    	// Run DFS from each of the neighbouring cells
    	dfs(grid, i-1, j, newColor, currColor, visited);
    	dfs(grid, i+1, j, newColor, currColor, visited);
    	dfs(grid, i, j-1, newColor, currColor, visited);
    	dfs(grid, i, j+1, newColor, currColor, visited);

    	// Change color if either border cell or if cell is on grid boundary
    	if (i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1 || isBorder) grid[i][j] = newColor;
    }

    public static void main(String[] args) {
    	int[][] grid = { {1,2,2}, {2,3,2} };
    	int row = 0, col = 1, color = 3;

    	int[][] board = colorBorder(grid, row, col, color);

    	for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
	        	System.out.print(board[i][j] + " ");
        	}
        	System.out.println("");
        }
    }
}