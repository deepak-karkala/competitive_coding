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
    		if (colors[neighbour] == colors[node]) return false;
    		if (colors[neighbour] == 0 && !dfs(adj, colors, neighbour, -color)) return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	int n = 3;
    	int[][] dislikes = { {1,2}, {1,3}, {2,3} };
    	boolean possible = possibleBipartition_dfs(n, dislikes);
    	System.out.println(possible);
    }
}