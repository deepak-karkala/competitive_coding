/*
1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
Medium
Topics
Companies
Hint
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] =
[fromi, toi, weighti] represents a bidirectional and weighted edge between cities
fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through
some path and whose distance is at most distanceThreshold, If there are multiple
such cities, return the city with the
greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum
of the edges' weights along that path.
*/
import java.util.*;

class FindTheCity {
	/*
	Approach: Floyd Warshall algorithm 
		(Shortest distance from every node to every other node)
	*/
    private static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 2D array to store distances from each node to every other node
        int[][] dist = new int[n][n];

        // Init distance with max value
        for(int i=0; i<n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        for(int i=0; i<n; i++) dist[i][i] = 0;
        // Build graph (update weights with given edges)
        for(int[] edge: edges) {
        	dist[edge[0]][edge[1]] = edge[2];
        	dist[edge[1]][edge[0]] = edge[2];
        }

        // Compute distances for every pair of nodes through each intermediate node
        for(int k=0; k<n; k++)
        	for(int i=0; i<n; i++) 
        		for(int j=0; j<n; j++) {
        			if (dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE &&
        				 dist[i][j] > dist[i][k] + dist[k][j]) {
        				dist[i][j] = dist[i][k] + dist[k][j];
        			}
        		}

        //for(int i=0; i<n; i++)
        //	for(int j=0; j<n; j++) System.out.println(i + "-" + j + ":" + dist[i][j]);

        // For each city, count number of cities below threshold distance
        int[] count = new int[n];
        for(int i=0; i<n; i++)
        	for(int j=0; j<n; j++)
        		if (dist[i][j] <= distanceThreshold) count[i]++;

        // Find the city with least such cities
        int min_count = Integer.MAX_VALUE;
        int min_idx = 0;
        for(int i=0; i<n; i++) {
        	if (count[i] <= min_count) {
        		min_count = count[i];
        		min_idx = i;
        	}
        }

        return min_idx;
    }

    public static void main(String[] args) {
    	int n = 5;
    	int[][] edges = { {0,1,2},{0,4,8},{1,2,3},{1,4,2}, {2,3,1}, {3,4,1}};
    	int distanceThreshold = 2;

    	System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}