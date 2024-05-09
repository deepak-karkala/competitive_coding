/*
133. Clone Graph
Solved
Medium
Topics
Companies
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph {
    // Goal: Create deep copies (clones) of all nodes
    //      copy list of neighbours of these new nodes same as existing nodes.
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Integer, Node> map) {
        if (node == null) return null;

        // If the clone node has already been created,
        //      return reference to that (stored in hashmap)
        //      If not, one more clone with same value will be created
        if (map.containsKey(node.val)) return map.get(node.val);
        // If this node has not been cloned yet,
        //      create a new node with same value, and
        //      traverse all its neighbours recursively (DFS)
        //      set all its neighbours and add it to clone's neighbours
        else {
            Node clone = new Node(node.val);
            map.put(node.val, clone);

            // Traverse all neighbours
            for (int i = 0; i < node.neighbors.size(); i++) {
                clone.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return clone;
        }
    }
}