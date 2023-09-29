/*
1202. Smallest String With Swaps
Medium
Topics
Companies
Hint
You are given a string s, and an array of pairs of indices in the string pairs where
pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps
*/
import java.util.*;

class SmallestStringWithSwaps {
	/*
	Approach: Disjoint set
	1. Each character is a node in the graph
	2. Union all pairs (form connected componenets)
		Use a HashMap to map from integer (root) -> List of Characters
	3. Within each connected component, sort the characters
		Alternate: Use a priority queue (avoid sorting characters)
	4. Insert the sorted characters in each connected component (disjoint set) to
		appropriate positions
			Iterate through string, find root (uf.find()) of each character, this
				will give which connected component to pick the next character to be
				inserted needs to come from.
	*/
    private static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    	if (s==null || s.length()==0) return null;

    	// Union find DS
    	UnionFind uf = new UnionFind(s.length());
    	// Union all pairs
    	for(List<Integer> pair: pairs) {
    		uf.union(pair.get(0), pair.get(1));
    	}

    	//Use a HashMap to map from integer (root) -> List of Characters in
    	//	each disjoint set
    	Map<Integer, List<Character>> map = new HashMap<>();
    	for(int i=0; i<s.length(); i++) {
    		int root = uf.find(i);
    		map.putIfAbsent(root, new ArrayList<Character>());
    		List<Character> characters = map.get(root);
    		characters.add(s.charAt(i));
    	}

    	// Sort characters in each disjoint set
    	for(List<Character> characters: map.values()) {
    		Collections.sort(characters);
    	}

    	// Insert sorted characters into right positions (based on root)
        StringBuilder sb = new StringBuilder(s.length());
    	for(int i=0; i<s.length(); i++) {
    		List<Character> characters = map.get(uf.find(i));
    		sb.append(characters.remove(0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	String s = "dcab";
    	List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0,3), Arrays.asList(1,2));
    	System.out.println(smallestStringWithSwaps(s, pairs));
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