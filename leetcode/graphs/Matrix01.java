/*
542. 01 Matrix
Medium
8.8K
388
Companies
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/
import java.util.*;

class Matrix01 {
	/*
	Approach: BFS
	Number of steps to 0 = shortest path to 0
	Details
		1. Start BFS from each 0. (Add all 0s to queue)
		2. All 1 neighbours of 0 will be first updated with dist=1, mark these as done, no need to update these
		3. Keep adding all neighbours of 0s to queue
		4. 1s with only other 1s as neighbours will then get updated with dist = dist_of_neighbour1 + 1
	Time: O(m*n) Space:O(m*n)
	*/
    private static int[][] updateMatrix_bfs(int[][] mat) {
    	int m=mat.length, n=mat[0].length;
    	Queue<int []> queue = new LinkedList<int []>();

    	// Start BFS from each 0. (Add all 0s to queue)
    	for(int i=0; i<mat.length; i++) {
    		for(int j=0; j<mat[0].length; j++) {
    			if (mat[i][j] == 0) queue.offer(new int[] {i,j});
    			else mat[i][j] = -1;	// 1s (unvisited)
    		}
    	}

    	// BFS from all nodes in queues (0s)
    	int[] dir = {0, 1, 0, -1, 0};
    	while(!queue.isEmpty()) {
    		int[] pos = queue.poll();
    		int r=pos[0], c=pos[1];

    		// Get neighbours (all 4 directions)
    		for(int i=0; i<4; i++) {
    			int nr = r + dir[i];
    			int nc = c + dir[i+1];

    			// Do nothing if out of bounds or if cell is already processed
    			if (nr<0 || nc<0 || nr>=m || nc>=n || mat[nr][nc]!=-1) continue;

    			mat[nr][nc] = mat[r][c] + 1;
    			queue.offer(new int[] {nr, nc});
    		}
    	}

    	return mat;
    }

    /*
    private static void bfs(int[][] mat, int[] pos, int[][] dist, boolean[][] visited) {

    	queue.offer(pos);

    	while(!queue.isEmpty()) {
    		int[] pair = queue.poll();
    		int i=pair[0], j=pair[1];
    		visited[i][j] = true;

    		int distance = dist[i][j];

    		if (i>=1) {
    			if (dist[i-1][j] != Integer.MAX_VALUE) distance = Math.min(dist[i-1][j] + 1, distance);
    			if (!visited[i-1][j]) queue.offer(new int[]{i-1, j});
    		} 
    		if (i<=mat.length-2) {
    			if (dist[i+1][j] != Integer.MAX_VALUE) distance = Math.min(dist[i+1][j] + 1, distance);
    			if (!visited[i+1][j]) queue.offer(new int[]{i+1, j});
    		}
    		if (j>=1) {
    			if (dist[i][j-1] != Integer.MAX_VALUE) distance = Math.min(dist[i][j-1] + 1, distance);
    			if (!visited[i][j-1]) queue.offer(new int[]{i, j-1});
    		}
    		if (j<=mat[0].length-2) {
    			if (dist[i][j+1] != Integer.MAX_VALUE) distance = Math.min(dist[i][j+1] + 1, distance);
    			if (!visited[i][j+1]) queue.offer(new int[]{i, j+1});
    		}
    		
    		if (mat[i][j]==1) {
    			dist[i][j] = distance;
    		}
    	}
    }
    */


    /*
    Approach DP
    	Compute distance from two directions
    		1. Top, left neighbours
    		2. Bottom, right neighbours
    	Use min of these two to compute final shortest distances
    */
    private static int[][] updateMatrix_dp(int[][] mat) {
    	int m=mat.length, n=mat[0].length;

    	// Distances from top, left neighbours
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			if (mat[i][j] == 0) continue;
    			int dist_top = m+n, dist_left = m+n;	//Since m+n is max or can set to MAX_VALUE
    			if (i>=1) dist_left = mat[i-1][j];
    			if (j>=1) dist_top = mat[i][j-1];
    			mat[i][j] = Math.min(dist_left, dist_top) + 1;
    		}
    	}

    	// Distances from bottom, right neighbours
    	for(int i=m-1; i>=0; i--) {
    		for(int j=n-1; j>=0; j--) {
    			if (mat[i][j] == 0) continue;
    			int dist_bottom = m+n, dist_right = m+n;	//Since m+n is max or can set to MAX_VALUE
    			if (i<=m-2) dist_right = mat[i+1][j];
    			if (j<=n-2) dist_bottom = mat[i][j+1];
    			mat[i][j] = Math.min(mat[i][j], Math.min(dist_right, dist_bottom)+1);
    		}
    	}
    	return mat;
    }

    public static void main(String[] args) {
    	int[][] mat = { {0,0,0}, {0,1,0}, {1,1,1} };
    	mat = updateMatrix_dp(mat);
    	for(int i=0; i<mat.length; i++) {
    		for(int j=0; j<mat[0].length; j++) {
    			System.out.print(mat[i][j] + " ");
    		}
    		System.out.println(" ");
    	}
    }
}