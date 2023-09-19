/*
547. Number of Provinces
Medium
Topics
Companies
There are n cities. Some of them are connected, while some are not. If city a is
connected directly with city b, and city b is connected directly with city c, then
city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities
outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city
and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
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

class NumberOfProvinces {
    private static int findCircleNum(int[][] isConnected) {
    	if (isConnected == null || isConnected.length == 0) return 0;
    	int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        // connect cities
        for(int i=0; i<n; i++) {
        	for(int j=i+1; j<n; j++) {
        		if (isConnected[i][j] == 1) uf.union(i, j);
        	}
        }

        // Return number of disjoint sets
        return uf.getNumOfDisjointSets();
    }

    public static void main(String[] args) {
    	int[][] isConnected = { {1,1,1}, {1,1,1}, {1,1,1} };
    	System.out.println(findCircleNum(isConnected));
    }
}