/*
886. Possible Bipartition
Medium
4.5K
103
Companies
We want to split a group of n people (labeled from 1 to n) into two groups
of any size. Each person may dislike some other people, and they should not
go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates
that the person labeled ai does not like the person labeled bi, return true if it
is possible to split everyone into two groups in this way.
*/

import java.util.*;

class PossibleBipartition {
	// Graph coloring: DFS
	// Time: O(V+E) Space: O(V+E)
    private static boolean possibleBipartition_dfs(int n, int[][] dislikes) {
    	// Create adj list, undirected graph
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
        for(int i=0; i<dislikes.length; i++) {
        	adj[dislikes[i][0]-1].add(dislikes[i][1]-1);
        	adj[dislikes[i][1]-1].add(dislikes[i][0]-1);
        }

        // Color 0:unvisited 1:Group1 -1:Group2
        int[] colors = new int[n];

        for(int i=0; i<n; i++) {
        	if (colors[i]==0 && !dfs(adj, colors, i, 1)) return false;
        }

        return true;
    }

    private static boolean dfs(List<Integer>[] adj, int[] colors, int node, int color) {
    	colors[node] = color;
    	for(int neighbour: adj[node]) {
    		// If at any point, color of this node and neighbour node is the same, return false
    		if (colors[neighbour] == colors[node]) return false;
    		if (colors[neighbour] == 0 && !dfs(adj, colors, neighbour, -color)) return false;
    	}
    	return true;
    }


    // Graph coloring: BFS
	// Time: O(V+E) Space: O(V+E)
    private static boolean possibleBipartition_bfs(int n, int[][] dislikes) {
    	// Create adj list, undirected graph
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
        for(int i=0; i<dislikes.length; i++) {
        	adj[dislikes[i][0]-1].add(dislikes[i][1]-1);
        	adj[dislikes[i][1]-1].add(dislikes[i][0]-1);
        }

        // Color 0:unvisited 1:Group1 -1:Group2
        int[] colors = new int[n];

        // Start BFS for each connected component
        for(int i=0; i<n; i++) {
        	if (colors[i] == 0) {
		        Queue<Integer> queue = new LinkedList<Integer>();
		        queue.offer(i);
		        colors[i] = 1;

		        while(!queue.isEmpty()) {
		        	int node = queue.poll();
		        	for(int neighbour: adj[node]) {
    					// If at any point, color of this node and neighbour node is the same, return false
		        		if (colors[neighbour] == colors[node]) return false;
		        		if (colors[neighbour] == 0) {
		        			colors[neighbour] = -colors[node];
		        			queue.offer(neighbour);
		        		}
		        	}
		        }
		    }
	    }
        return true;
    }

    public static void main(String[] args) {
    	int n = 5;
    	int[][] dislikes = { {1,2}, {3,4}, {4,5}, {3,5} };
    	boolean possible = possibleBipartition_bfs(n, dislikes);
    	System.out.println(possible);
    }
}