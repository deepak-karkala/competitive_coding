/*
994. Rotting Oranges
Medium
11.7K
364
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/

import java.util.*;

class RottingOranges {
	/*
	Approach: BFS
		1. Add rotting oranges to queue in BFS
		2. Increment timestep
		3. Run BFS from 1st neighbours of rotting oranges
		4. Recursively run BFS until all oranges are visited
	*/
    private static int orangesRotting(int[][] grid) {
        Queue<int []> queue = new LinkedList<int []>();
        int m = grid.length, n = grid[0].length;

        // Add all rotten oranges to queue
        boolean isFreshOranges = false;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j] == 2) queue.offer(new int[]{i, j});
        		if (!isFreshOranges && grid[i][j] == 1) isFreshOranges = true;
        	}
        }

        // Return 0 if no oranges at all
        if (queue.size()==0 && !isFreshOranges) return 0;

        // Return -1 if no rotting oranges
        if (queue.size()==0) return -1;

        // Return 0 if no fresh oranges
        if (!isFreshOranges) return 0;

        // Run BFS recursively until all oranges are visited
        int time = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();

        	for(int k=0; k<size; k++) {
        		int[] pos = queue.poll();
        		int i=pos[0], j=pos[1];


        		if (i>=0 && j>=0 && i<m && j<n && grid[i][j]!=0) {
	        		// Mark as visited
	        		grid[i][j] = 2;

	        		// Add all 4 direction neighbours
	        		queue.offer(new int[]{i-1, j});
	        		queue.offer(new int[]{i+1, j});
	        		queue.offer(new int[]{i, j-1});
	        		queue.offer(new int[]{i, j+1});
	        	}
        	}
        	time++;
        }

        // Check if (unvisited) fresh oranges are remaining
        boolean isFreshOrangesRemaining = false;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (grid[i][j] == 1) isFreshOrangesRemaining = true;
        	}
        }

        return isFreshOrangesRemaining ? -1 : time-2;
    }

    public static void main(String[] args) {
    	int[][] grid = { {2,1,1}, {1,1,0}, {0,1,1} };
    	System.out.println(orangesRotting(grid));
    }
}