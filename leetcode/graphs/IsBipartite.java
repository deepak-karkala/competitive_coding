/*
785. Is Graph Bipartite?
Medium
7.7K
342
Companies
There is an undirected graph with n nodes, where each node is numbered between
0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes
that node u is adjacent to. More formally, for each v in graph[u], there is an
undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that
there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A
and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.
*/

class IsBipartite {
	// Graph coloring: DFS
	// Time: O(V+E) Space: O(V+E)
    private static boolean isBipartite_dfs(int[][] graph) {
		// Graph coloring 0:Unvisited 1:Group1 -1:Group2
		int n = graph.length;
		int[] colors = new int[n];

		for(int i=0; i<n; i++) {
			if (colors[i]==0 && !dfs(graph, colors, i, 1)) return false;
		}
		return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int node, int color) {
    	colors[node] = color;
    	for(int neighbour: graph[node]) {
    		if (colors[neighbour] == colors[node]) return false;
    		if (colors[neighbour]==0 && !dfs(graph, colors, neighbour, -color)) return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	int[][] graph = { {1,3},{0,2},{1,3},{0,2} };
    	boolean possible = isBipartite_dfs(graph);
    	System.out.println(possible);
    }
}