/*
1319. Number of Operations to Make Network Connected
Medium
Topics
Companies
Hint
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections
forming a network where connections[i] = [ai, bi] represents a connection between computers
ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables
between two directly connected computers, and place them between any pair of disconnected
computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers
connected. If it is not possible, return -1.
*/

class MakeConnected {
    /*
    Approach: Disjoint set
    Initially: Number of disjoint sets = n
    If connections.length (number of cables) < n-1 return -1
    Keep unioning based on list in connections, 
        If two nodes have different heads, decrementing numDisjointSets by 1
        If two nodes have same heads, this connection can be removed and be 
            used to connect a new node
    At the end, 
        number of cables required = number of unconnected components - 1
                                  = numDisjointSets - 1
    */
    private static int makeConnected(int n, int[][] connections) {
        // Min n-1 connections required to connect all nodes
        if (connections.length < n-1) return -1;

        UnionFind uf = new UnionFind(n);

        for(int[] pair: connections) {
            uf.union(pair[0], pair[1]);
        }
        return uf.getNumOfDisjointSets() - 1;
    }
    public static void main(String[] args) {
    	int n = 6;
    	int[][] connections = { {0,1},{0,2},{0,3},{1,2} };
    	System.out.println(makeConnected(n, connections));
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