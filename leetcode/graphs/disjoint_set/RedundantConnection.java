/*
684. Redundant Connection
Medium
Topics
Companies
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one
additional edge added. The added edge has two different vertices chosen from 1 to n,
and was not an edge that already existed. The graph is represented as an array edges
of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai
and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes.
If there are multiple answers, return the answer that occurs last in the input.
*/


class UnionFind {
	private int[] root;
	private int[] rank;
	private int numDisjointSets;

	// Constructor
	UnionFind(int size) {
		root = new int[size];
		rank = new int[size];
		numDisjointSets = size;

		// Init root nodes as own and rank as 1 for all nodes
		for(int i=0; i<size; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}

	// Find root node (by path compression)
	public int find(int x) {
		if (x == root[x]) return x;
		return root[x] = find(root[x]);
	}

	// Union by rank
	public boolean union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY) return false;
		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}

			// For every union, decrement numDisjointSets by 1
			numDisjointSets--;
		}
		return true;
	}

	public int getNumOfDisjointSets() {
		return numDisjointSets;
	}
}


class RedundantConnection {
	/*
	Approach: Disjoint set
	Keep adding edges (union)
	Check if the two nodes have same root, if they have that's
		the redundant edge
	Time: O(alpha*N) Space: O(N)
	*/
	private static int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] additional_edge = new int[2];

        for(int[] edge: edges) {
        	if (!uf.union(edge[0]-1, edge[1]-1)) {
        		additional_edge = edge;
        		break;
        	}
        }

        return additional_edge;
    }


    public static void main(String[] args) {
    	int[][] edges = { {1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
    	int[] edge = findRedundantConnection(edges);
    	System.out.println(edge[0] + " " + edge[1]);
    }
}