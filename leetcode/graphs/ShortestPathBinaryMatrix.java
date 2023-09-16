/*
1091. Shortest Path in Binary Matrix
Medium
6K
207
Companies
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the
bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different
and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/
import java.util.*;

class ShortestPathBinaryMatrix {
	/*
	Approach: BFS
		1. Run BFS starting from 0,0
		2. Add 8 direction neighbours and keep running BFS
		3. When m-1,n-1 cell is reached, return length
	*/
    private static int shortestPathBinaryMatrix(int[][] grid) {
    	int m = grid.length, n = grid[0].length;

    	// Return -1 if top left cell or bottom right is 1
    	if (grid[0][0]==1 || grid[m-1][n-1]==1) return -1;

    	// Add 0,0 to BFS queue
    	Queue<int[]> queue = new LinkedList<int []>();
    	queue.offer(new int[]{0, 0});

    	int len = 0;
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		len++;

    		for(int k=0; k<size; k++) {
    			int[] pos = queue.poll();
	    		int i=pos[0], j=pos[1];	

	    		if (i==m-1 && j==n-1) return len;

	    		if (i>=0 && j>=0 && i<m && j<n && grid[i][j]==0) {
	    			// Mark this cell as visited
	    			grid[i][j] = 2;

	    			// Add right, bottom and diagonal neighbours
	    			queue.offer(new int[] {i-1, j});
	    			queue.offer(new int[] {i+1, j});
	    			queue.offer(new int[] {i, j-1});
	    			queue.offer(new int[] {i, j+1});
	    			queue.offer(new int[] {i-1, j-1});
	    			queue.offer(new int[] {i-1, j+1});
	    			queue.offer(new int[] {i+1, j-1});
	    			queue.offer(new int[] {i+1, j+1});
	    		}
    		}
    	}

    	return grid[m-1][n-1]==2 ? len-1 : -1;
    }

    public static void main(String[] args) {
		int[][] grid = {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
    	//int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
    	System.out.println(shortestPathBinaryMatrix(grid));
    }
    	
}