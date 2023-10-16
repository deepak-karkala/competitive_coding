/*
797. All Paths From Source to Target
Medium
Topics
Companies
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all
possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from
node i (i.e., there is a directed edge from node i to node graph[i][j])
*/
import java.util.*;

class AllPathsSourceTarget {
	/*
	Approach: Backtracking
	1. Start from 0th node
	2. Visit all the nodes reachable from 0th node
			Recurse further from each of those nodes
	3. Add path to final result when destination node is reached.
	*/
    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer>list = new ArrayList<Integer>();
        list.add(0);
        backtrack(lists, list, graph, 0);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> list, int[][] graph, int node) {
    	if (node == graph.length-1) {
    		lists.add(new ArrayList<>(list));
    	} else {
    		// Iterate through each of the paths available from this node
    		for(int dest: graph[node]) {
    			list.add(dest);
    			backtrack(lists, list, graph, dest);
    			list.remove(list.size()-1);
    		}
    	}
    	return;
    }

    public static void main(String[] args) {
    	int[][] graph = { {4,3,1},{3,2,4},{3},{4},{} };
    	List<List<Integer>> lists = allPathsSourceTarget(graph);
    	for(List<Integer> list: lists) {
    		System.out.println(list);
    	}
    }
}