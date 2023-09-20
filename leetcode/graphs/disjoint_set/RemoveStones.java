/*
947. Most Stones Removed with Same Row or Column
Medium
Topics
Companies
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate
point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another
stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location
of the ith stone, return the largest possible number of stones that can be removed.
*/

class RemoveStones {
	/*
	Approach: Disjoint set
	Initial: Number of disjoint sets = number of stones
	Each time union, if same root (row or column), decrement numDisjointSets
	At the end, number of stones can be removed = 
		initialnumber of stones - numDisjoinstSets
	*/
    private static int removeStones_uf(int[][] stones) {
    	int numTotalStones = stones.length;
        UnionFind uf = new UnionFind(numTotalStones);

        for (int i=0; i<stones.length; i++) {
        	for(int j=i+1; j<stones.length; j++) {
        		if (stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) uf.union(i, j);
        	}
        }
        return numTotalStones - uf.getNumOfDisjointSets();
    }

    /*
    Approach: DFS
    Run DFS from each unvisited node (increment number of disjoint sets)
    At the end, number of stones can be removed = 
		initialnumber of stones - numDisjoinstSets
	Time: O(n^2) worst case Space: O(n)
    */
    private static int removeStones_dfs(int[][] stones) {
    	int numTotalStones = stones.length;
    	boolean[] visited = new boolean[numTotalStones];
    	int numDisjointSets = 0;

    	// Run DFS from each unvisited node
    	for(int i=0; i<numTotalStones; i++) {
    		if (!visited[i]) {
    			dfs(stones, visited, i);
    			numDisjointSets++;
    		}
    	}

    	return numTotalStones - numDisjointSets;
    }

    private static void dfs(int[][] stones, boolean[] visited, int n) {
    	visited[n] = true;

    	// Run DFS from each unvisited neighbour
    	for(int i=0; i<stones.length; i++) {
    		if (!visited[i]) {
    			if (stones[i][0]==stones[n][0] || stones[i][1]==stones[n][1]) dfs(stones, visited, i);
    		}
    	}
    }

    public static void main(String[] args) {
    	int[][] stones = { {0,0},{0,1},{1,0},{1,2},{2,1},{2,2} };
    	System.out.println(removeStones_uf(stones));
    }
}

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
	public void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);

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
	}

	public int getNumOfDisjointSets() {
		return numDisjointSets;
	}
}