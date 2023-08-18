/*
1971. Find if Path Exists in Graph
Easy
3.2K
153
Companies
There is a bi-directional graph with n vertices, where each vertex is
labeled from 0 to n - 1 (inclusive). The edges in the graph are represented
as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a
bi-directional edge between vertex ui and vertex vi. Every vertex pair is
connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source
to vertex destination.

Given edges and the integers n, source, and destination, return true if there
is a valid path from source to destination, or false otherwise.
*/

import java.util.*;

class GraphValidPath {
	// Approach 1: BFS Path exists
	// Time: O(V + E) Space: O(V)
	private static boolean validPath_bfs(int n, int[][] edges, int source, int destination) {
		if (source == destination) return true;

		// Init graph and add edges
		LinkedList<Integer> adj[] = new LinkedList[n];
		for(int i=0; i<n; i++) adj[i] = new LinkedList<Integer>();
		for(int i=0; i<edges.length; i++) {
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}

		// BFS init
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];

		queue.add(source);
		visited[source] = true;

		// Iterate till queue is empty
		while(queue.size() != 0) {
			int node = queue.poll();

			// Add all nodes in this node's adj list to queue
			for(int v: adj[node]) {
				if (visited[v] != true) {
					visited[v] = true;
					queue.add(v);
					if (v == destination) return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args){
		int num_nodes = 10;
		int[][] edges = { {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5} };

		boolean is_path = validPath_bfs(num_nodes, edges, 7, 5);
		System.out.println(is_path);
	}
}