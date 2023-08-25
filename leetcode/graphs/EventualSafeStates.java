/*
802. Find Eventual Safe States
Medium
5.2K
427
Companies
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is
represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes
adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every
possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in
ascending order.
*/

import java.util.*;

class EventualSafeStates {

	enum State {Unvisited, Visiting, Visited};

	// Approach: DFS Cycle detection
	// Time: O(V+E)
	private static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<Integer>();
        State[] state = new State[graph.length];
        Arrays.fill(state, State.Unvisited);

        // DFS for all nodes and check if there are cycles
        for(int i=0; i<graph.length; i++) {
        	// If no cycle from this node, then add to result
        	if (dfs(graph, i, state)) res.add(i);
        }

        return res;
    }


    private static boolean dfs(int[][] graph, int idx, State[] state) {
    	// If we encounter being visited vertex again => cycle return false
    	if (state[idx] == State.Visiting) return false;
    	// If already finished visited => no cycle, terminal or safe node
    	if (state[idx] == State.Visited) return true;

    	state[idx] = State.Visiting;
    	for(int v: graph[idx]) {
    		if (state[v] == State.Visiting) return false;
    		if (state[v] == State.Unvisited && !dfs(graph, v, state)) return false;
    	}
    	state[idx] = State.Visited;
    	return true;
    }


    // BFS: Topological sort
    //		Start with terminal/safe nodes, add to queue
    //		Poll from queue, add node to result as safe node
	//			Scan all nodes ending at this node, decrement outdegree by 1
	//			If outdegree==0, add this node to queue
	//		To scan all nodes ending at this node, build a reverse adj list
    // Time: O(V + E)
	private static List<Integer> eventualSafeNodes_bfs(int[][] graph) {
		// Array to track outdegree
		int[] outdegree = new int[graph.length];

		// Build reverse adjacency list
		List<Integer>[] adj = new ArrayList[graph.length];
		for(int i=0; i<graph.length; i++) adj[i] = new ArrayList<Integer>();
		for(int i=0; i<graph.length; i++) {
			for(int neighbour: graph[i]) {
				adj[neighbour].add(i);
				outdegree[i]++;
			}
		}

		// Start with terminal (safe) nodes (outdegree=0), add to queue
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<graph.length; i++) {
			if (outdegree[i] == 0) queue.offer(i);
		}

		List<Integer> res = new ArrayList<Integer>();
		// BFS
		while(!queue.isEmpty()) {
			int v = queue.poll();
			res.add(v);

			// Scan all neighbours (nodes from where there is an edge to
			// safe node) of safe nodes
			// When outdegree==0 add to queue, mark as safe node
			for(int u: adj[v]) {
				outdegree[u]--;
				if (outdegree[u]==0) queue.offer(u);
			}
		}

		Collections.sort(res);
		return res;
    }


    public static void main(String[] args) {
    	int[][] graph = { {1,2}, {2,3}, {5}, {0}, {5}, {}, {}};
    	List<Integer> list = eventualSafeNodes_bfs(graph);
    	for(int i: list) System.out.println(i);
    }
}