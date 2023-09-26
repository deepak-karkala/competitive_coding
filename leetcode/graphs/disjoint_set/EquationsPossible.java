/*
990. Satisfiability of Equality Equations
Medium
Topics
Companies
You are given an array of strings equations that represent relationships between variables
where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi"
or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent
one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the
given equations, or false otherwise.
*/

import java.util.*;

class EquationsPossible {
	/*
	Approach: Disjoint set
	Union variables of all equality equations
	If any contradiction in inequality equation, then not possible
	Time: O(n)
	*/
    private static boolean equationsPossible(String[] equations) {
    	// find number of variables
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	int i = 0;
    	for(String s: equations) {
    		if (!hm.containsKey(s.charAt(0))) hm.put(s.charAt(0), i++);
    		if (!hm.containsKey(s.charAt(3))) hm.put(s.charAt(3), i++);
    	}
    	int size = hm.size();
        UnionFind uf = new UnionFind(size);

        // Union variables of all equality equations
    	for(String s: equations) {
    		if (s.charAt(1)=='=') uf.union(hm.get(s.charAt(0)), hm.get(s.charAt(3)));
        }

		// If any contradiction in inequality equation, then not possible, return false
    	for(String s: equations) {
    		if (s.charAt(1)=='!' && uf.find(hm.get(s.charAt(0)))==uf.find(hm.get(s.charAt(3)))) return false;
		}        
        return true;
    }

    /*
	Approach: Disjoint set
	Union variables of all equality equations
	If any contradiction in inequality equation, then not possible
	Time: O(n)
	*/
    private static boolean equationsPossible2(String[] equations) {
        UnionFind uf = new UnionFind(26);

        // Union variables of all equality equations
    	for(String s: equations) {
    		if (s.charAt(1)=='=') uf.union(s.charAt(0)-'a', s.charAt(3)-'a');
        }

		// If any contradiction in inequality equation, then not possible, return false
    	for(String s: equations) {
    		if (s.charAt(1)=='!' && uf.find(s.charAt(0)-'a')==uf.find(s.charAt(3)-'a')) return false;
		}        
        return true;
    }

    public static void main(String[] args) {
    	String[] equations = {"a==b","c==d","a==c","a!=d"};
    	System.out.println(equationsPossible2(equations));
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