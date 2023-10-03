/*
787. Cheapest Flights Within K Stops
Medium
Topics
Companies
There are n cities connected by some number of flights. You are given an array flights
where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi
to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to
dst with at most k stops. If there is no such route, return -1.
*/

import java.util.*;

class CheapestFlight {
	/*
	Approach: BFS
	1. Run BFS from source
	2. Stop at k steps
	3. If dest not reached, return -1, if not return cheapest path
	*/
    private static int findCheapestPrice_bfs(int n, int[][] flights, int src, int dst, int k) {
    	int price_to_dst = Integer.MAX_VALUE;

        // Build Graph
    	List<int[]>[] adj = new ArrayList[n];
    	for(int i=0; i<n; i++) adj[i] = new ArrayList<int[]>();
    	for(int[] flight: flights) {
    		adj[flight[0]].add(new int[]{flight[1], flight[2]});
    	}

    	int num_stops = 0;
    	// PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    	// pq.offer(new int[]{src, 0, 0});
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[]{src, 0});	// Node, price

    	while(!queue.isEmpty() && k-->=0) {
    		int size = queue.size();
    		for(int i=0; i<size; i++) {
    			int[] curr = queue.poll();
    			int u = curr[0];
    			int price_to_u = curr[1];
    			if (price_to_u > price_to_dst) continue;

    			for(int[] next: adj[u]) {
    				int v = next[0];
    				int price_u_to_v = next[1];

    				if (v == dst) price_to_dst = Math.min(price_to_dst, price_to_u + price_u_to_v);
    				queue.offer(new int[]{v, price_to_u + price_u_to_v});
    			}
    		}
    	}

    	if (price_to_dst != Integer.MAX_VALUE) return price_to_dst;
    	return -1;
    }


    /*
	Approach: Dijkstra
	1. Use PQ to traverse through nodes in order of hops (?)
	2. If dest not reached, return -1, if not return cheapest path
	*/
    private static int findCheapestPrice_dijkstra(int n, int[][] flights, int src, int dst, int k) {
    	int price_to_dst = Integer.MAX_VALUE;

        // Build Graph
    	List<int[]>[] adj = new ArrayList[n];
    	for(int i=0; i<n; i++) adj[i] = new ArrayList<int[]>();
    	for(int[] flight: flights) {
    		adj[flight[0]].add(new int[]{flight[1], flight[2]});
    	}

    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    	pq.offer(new int[]{src, 0, k+1});		//Node, price, num_stops_remaining

    	// To track if visited
    	boolean[] visited = new boolean[n];

    	while(!pq.isEmpty()) {
    		int[] curr = pq.poll();
    		int node = curr[0];
    		int price = curr[1];
    		int num_stops_remaining = curr[2];

    		// If current node is destination, return current price (it will be least due to PQ)
    		if (node == dst) return price;

    		// If more than 0 stops remaining at this node, add all its neighbours to PQ
    		if (num_stops_remaining > 0)
    			for(int[] neighbours: adj[node])
    				pq.offer(new int[]{neighbours[0], price+neighbours[1], num_stops_remaining-1});
    	}

    	return -1;
    }

    /*
	Approach: Bellman Ford
	1. ITerate through all edges for K times (instead of N times in standard BF)
	2. If dest not reached, return -1, if not return cheapest path
	*/
    private static int findCheapestPrice_bellmanford(int n, int[][] flights, int src, int dst, int k) {
    	// Price from src to all nodes
    	int[] dist = new int[n];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[src] = 0;

    	for(int i=0; i<=k; i++) {
    		int[] temp= Arrays.copyOf(dist, n);
    		for(int[] flight: flights) {
    			int u = flight[0];
    			int v = flight[1];
    			int puv = flight[2];

    			if (dist[u]==Integer.MAX_VALUE) continue;
    			temp[v] = Math.min(temp[v], dist[u] + puv);
    		}
    		dist = temp;
    	}

    	return dist[dst] == Integer.MAX_VALUE ? -1: dist[dst];
    }

    public static void main(String[] args) {
    	int n = 4;
    	int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
    	//int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
    	int src = 0;
    	int dst = 3;
    	int k = 1;

    	System.out.println(findCheapestPrice_bellmanford(n, flights, src, dst, k));
    }
}