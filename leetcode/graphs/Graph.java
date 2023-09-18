import java.util.*;

class Graph {
	private static int[] nodes;
	private static LinkedList<Integer> adj[];

	Graph(int num_nodes) {
		nodes = new int[num_nodes];
		adj = new LinkedList[num_nodes];
		for(int i=0; i<num_nodes; i++) adj[i] = new LinkedList<Integer>();
	}

	private static void addEdge(int s, int d) {
		adj[s].add(d);
	}

	private static void addEdges(int[][] edges) {
		for(int i=0; i<edges.length; i++) {
			addEdge(edges[i][0], edges[i][1]);
			// Enable this for bi-directional graphs
			addEdge(edges[i][1], edges[i][0]);
		}
	}


	// Breadth first search - Iterative using queue
	private static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[nodes.length];

		// Add source to queue and mark it as visited
		queue.add(s);
		visited[s] = true;

		// Iterate till queue is empty
		while(queue.size() != 0) {
			int node = queue.poll();

			// Add all nodes in this node's adj list to queue
			for(int v: adj[node]) {
				if (visited[v] != true) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}

	private static boolean bfs_path_exists(int s, int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[nodes.length];

		// Add source to queue and mark it as visited
		queue.add(s);
		visited[s] = true;

		// Iterate till queue is empty
		while(queue.size() != 0) {
			int node = queue.poll();

			// Add all nodes in this node's adj list to queue
			for(int u: adj[node]) {
				if (visited[u] != true) {
					visited[u] = true;
					queue.add(u);
					if (u == v) return true;
				}
			}
		}
		return false;
	}

	// Depth first search - Iterative using stack
	private static void dfs(int s) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[nodes.length];

		// Add source to queue and mark it as visited
		stack.push(s);
		visited[s] = true;

		// Iterate till queue is empty
		while(stack.size() != 0) {
			int node = stack.pop();

			// Add all nodes in this node's adj list to queue
			for(int v: adj[node]) {
				if (visited[v] == false) {
					visited[v] = true;
					stack.push(v);
					//System.out.println(v);
				}
			}
		}
	}

	// Depth first search - recursive
	private static void dfs_recursive_top(int s) {
		boolean[] visited = new boolean[nodes.length];
		dfs_recursive(s, visited);
	}

	private static void dfs_recursive(int s, boolean[] visited) {
		visited[s] = true;
		System.out.println(s);

		// Add all nodes in this node's adj list to queue
		for(int v: adj[s]) {
			if (visited[v] == false) {
				visited[v] = true;
				dfs_recursive(v, visited);
			}
		}
	}

	public static void main(String[] args){
		int num_nodes = 10;
		Graph g = new Graph(num_nodes);
		int[][] edges = { {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5} };
		addEdges(edges);

		// BFS
		dfs_recursive_top(0);
		//boolean is_path = bfs_path_exists(0, 2);
		//System.out.println(is_path);
	}
}