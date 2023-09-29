/*
743. Network Delay Time
Medium
6.9K
339
Companies
You are given a network of n nodes, labeled from 1 to n. You are also given times,
a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the
source node, vi is the target node, and wi is the time it takes for a signal to
travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all
the n nodes to receive the signal. If it is impossible for all the n nodes to receive
the signal, return -1.
*/


import java.util.*;


class NetworkDelay {

	// Approach: BFS
    private static int networkDelayTime_dijkstras(int[][] times, int n, int k) {
    	int[] time = new int[n];
    	for(int i=0; i<time.length; i++) time[i] = Integer.MAX_VALUE;
    	time[k-1] = 0;

    	List<Integer>[] adj = new ArrayList[n];
    	for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
    	for(int i=0; i<times.length; i++) adj[times[i][0]-1].add(times[i][1]-1);

    	// Build adj matrix
    	int[][] weight = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }
    	for(int i=0; i<times.length; i++) {
    		weight[times[i][0]-1][times[i][1]-1] = times[i][2];
    	}

    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.offer(k-1);
        boolean[] visited = new boolean[n];
        //visited[k-1] = true;

    	while(!queue.isEmpty()) {
    		int u = queue.poll();
            visited[u] = true;

    		for(int v: adj[u]) {
    			time[v] = Math.min(time[u] + weight[u][v], time[v]);
    			//System.out.println(v + "-" + time[v]);
    			if (!visited[v]) queue.offer(v);
    		}
    	}

    	int max = Integer.MIN_VALUE;
    	for(int i=0; i<time.length; i++) {
    		if (time[i] == Integer.MAX_VALUE) return -1;
    		if (time[i] > max) max = time[i];
    	}

    	return max;
    }

    /*Shortest path: Bellman Ford*/
    private static int networkDelayTime_bellmanFord(int[][] times, int n, int k) {
        // Set initial distances to max
        int[] dist = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        dist[k-1] = 0;

        // Compute distances for each pair of nodes
        for(int i=0; i<n; i++) {
            for(int j=0; j<times.length; j++) {
                int u = times[j][0] - 1;
                int v = times[j][1] - 1;
                int w = times[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Find the longest time amongst all nodes
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            if (dist[i] > max) max = dist[i];
        }


        return max;
    }

    public static void main(String[] args) {
    	int[][] times = { {2,1,1}, {2,3,1}, {3,4,1} };
    	int min = networkDelayTime_bellmanFord(times, 4, 2);
    	System.out.println(min);
    }
}