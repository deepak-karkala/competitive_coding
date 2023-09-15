/*
1162. As Far from Land as Possible
Medium
4K
106
Companies
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1
represents land, find a water cell such that its distance to the nearest land cell
is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between
two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
*/

import java.util.*;

class IslandMaxDistance {
	/*
	Approach: BFS
		1. Run BFS from all land nodes (1s)
		2. All immediate water neighbours distance will be updated to 1.
		3. Keep track of visited nodes, because this is BFS, 
			don't have to update distance later, nodes will be processed
			in the order of their distances.
		3. Add these nodes to queue for further BFS from these nodes
		4. Keep updating distances at every BFS step
		5. Scan through all water nodes (0s) to get ma distance.
	Time: O(m*n)
	*/
    private static int maxDistance(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int []>();

        boolean isLand = false, isWater = false;
        // Add all land nodes's neighbours to queue for further BFS
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		// For each land node,
        		if (grid[i][j] == 1)  {
        			// Add all neighbours
        			queue.offer(new int[]{i-1, j});
        			queue.offer(new int[]{i+1, j});
        			queue.offer(new int[]{i, j-1});
        			queue.offer(new int[]{i, j+1});
        		}
        		if (!isLand && grid[i][j]==1) isLand = true;
        		if (!isWater && grid[i][j]==0) isWater = true;
        	}
        }

        // Return -1 if no water or no land found
        if (!isLand || !isWater) return -1;

        // Process till queue is empty
        int bfs_step = 0;

        while(!queue.isEmpty()) {
        	// Increment BFS step (distance from source)
        	bfs_step++;
        	// Pop all nodes
        	int size = queue.size();
        	for(int k=0; k<size; k++) {
        		int[] pos = queue.poll();
        		int i=pos[0], j=pos[1];

        		//System.out.println(i + " " + j + " " + n);

        		// Consider this node only if within bounds and not visited and if it is water node
        		if (i>=0 && j>=0 && i<m && j<n && !visited[i][j] && grid[i][j]==0) {
        			grid[i][j] = bfs_step;
        			visited[i][j] = true;

        			// Add all neighbours for further BFS
        			queue.offer(new int[]{i-1, j});
        			queue.offer(new int[]{i+1, j});
        			queue.offer(new int[]{i, j-1});
        			queue.offer(new int[]{i, j+1});
        		}
        	}
        }

        int maxDistance = Integer.MIN_VALUE;
		//Scan through all water nodes (0s) to get ma distance.
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		maxDistance = Math.max(maxDistance, grid[i][j]);
        	}
        }

        return maxDistance;
    }

    public static void main(String[] args) {
    	int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
    	System.out.println(maxDistance(grid));
    }
}