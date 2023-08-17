/*
1791. Find Center of Star Graph
Easy
1.2K
140
Companies
There is an undirected star graph consisting of n nodes labeled from 1 to n.
A star graph is a graph where there is one center node and exactly n - 1 edges
that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates
that there is an edge between the nodes ui and vi. Return the center of the given star graph.
*/


class StarGraphCentre {

	private static int findCenter(int[][] edges) {
        int choice1 = edges[0][0];
        int choice2 = edges[0][1];

        if (edges[1][0]==choice1 || edges[1][1]==choice1) return choice1;
        return choice2;
    }

    public static void main(String[] args) {
    	int[][] edges = { {1,2}, {2,3}, {4,2} };
    	int centre = findCenter(edges);
    	System.out.println(centre);
    }

}