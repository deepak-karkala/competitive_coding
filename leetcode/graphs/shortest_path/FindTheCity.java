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
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<int[]>();
        for(int[] edge: edges) {
        	int u = edge[0], v = edge[1], uv = edge[2];
            adj[u].add(new int[]{v, uv});
            adj[v].add(new int[]{u, uv});
        }

        //floyd_warshall(n, dist);
        // Run BFS (Dijkstra / BellmanFord / SPFA from each node)
        for(int src=0; src<n; src++) {
            dijkstra(n, dist[src], adj, src);
            // bellman_ford(n, dist[src], edges, src);
            // spfa(n, dist[src], adj, src);
        }

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


    private static void floyd_warshall(int n, int[][] dist) {
        // Compute distances for every pair of nodes through each intermediate node
        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++) 
                for(int j=0; j<n; j++) {
                    if (dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE &&
                         dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
        return;
    }

    /*
	Approach: BFS (Dijkstra's)
		1. Run BFS from each node
		2. Count number of cities with distance to other cities less than threshold
		3. Find the city with least such cities
    */
    private static void dijkstra(int n, int[] dist, List<int[]>[] adj, int src) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    	pq.offer(new int[]{src, 0});

    	while(!pq.isEmpty()) {
    		int[] node = pq.poll();
            int u = node[0];
            int du = node[1];

            // Check if du (distance from src to u through node v) with
            //  dist[u] (min distance from src to u through all nodes so far)
            // If du > dist[u], then don't check further nodes through u (no BFS, u not added to queue)
            // This and Priority queue (go through nodes in ascending order of distances)
            //     is what separates Dijkstra's from SPFA
            if (du > dist[u]) continue;

            // Iterate through all neighbouring nodes
            // Because of PQ, nodes will be iterated in order of shortest distances
            for(int[] next: adj[u]) {
                int v = next[0];
                int duv = next[1];

                if (dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + duv) {
                    dist[v] = dist[u] + duv;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
    	}
    }

    /*
    Approach: BFS (Bellman Ford)
        1. Run BFS from each node
        2. Count number of cities with distance to other cities less than threshold
        3. Find the city with least such cities
    */
    private static void bellman_ford(int n, int[] dist, int[][] edges, int src) {
        // Run |V| times all edges
        for(int k=1; k<n; k++) {
            for(int[] edge: edges) {
                int u = edge[0], v = edge[1], uv = edge[2];
                if (dist[v]!=Integer.MAX_VALUE && dist[u] > dist[v] + uv)
                    dist[u] = dist[v] + uv;
                if (dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + uv)
                    dist[v] = dist[u] + uv;
            }
        }
    }


    /*
    Approach: SPFA (Bellman Ford using queue)
        1. Run BFS from each node
        2. Count number of cities with distance to other cities less than threshold
        3. Find the city with least such cities
    */
    private static void spfa(int n, int[] dist, List<int[]>[] adj, int src) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(src);

        while(!queue.isEmpty()) {
            int u = queue.poll();

            for(int[] next: adj[u]) {
                int v = next[0];
                int uv = next[1];
                if (dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + uv) {
                    dist[v] = dist[u] + uv;
                    queue.offer(v);
                }
            }

        }
    }

    public static void main(String[] args) {
    	int n = 5;
    	int[][] edges = { {0,1,2},{0,4,8},{1,2,3},{1,4,2}, {2,3,1}, {3,4,1}};
    	int distanceThreshold = 2;

    	System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}