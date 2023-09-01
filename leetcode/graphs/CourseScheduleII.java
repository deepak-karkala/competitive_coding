/*
210. Course Schedule II
Medium
9.9K
311
Companies
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid
answers, return any of them. If it is impossible to finish all courses, return an empty array.
*/


import java.util.*;


class CourseScheduleII {

	// Approach: BFS Topological Sort
    private static int[] findOrder_bfs(int numCourses, int[][] prerequisites) {
    	boolean[] visited = new boolean[numCourses];
    	int[] indegree = new int[numCourses];
    	List<Integer>[] adj = new ArrayList[numCourses];
    	for(int i=0; i<numCourses; i++) adj[i] = new ArrayList<Integer>();

    	// Build adjacency list
    	for(int i=0; i<prerequisites.length; i++) {
    		adj[prerequisites[i][1]].add(prerequisites[i][0]);
    		indegree[prerequisites[i][0]]++;
    	}

    	Queue<Integer> queue = new LinkedList<Integer>();
    	for(int i=0; i<numCourses; i++) {
    		if (indegree[i] == 0) queue.offer(i);
    	}

    	List<Integer> res = new ArrayList<Integer>();
    	// Iterate till queue is not empty
    	while (!queue.isEmpty()){
    		int u = queue.poll();
    		res.add(u);

    		for(int v: adj[u]) {
    			indegree[v]--;
    			if (indegree[v] == 0) queue.offer(v);
    		}
    	}

    	if (res.size() == numCourses) {
    		int[] order = new int[numCourses];
    		for(int i=0; i<numCourses; i++) order[i] = res.get(i);
    		return order;
    	}

    	return new int[0];
	}

	public static void main(String[] args) {
    	int numCourses = 4;
    	int[][] prerequisites = { {1,0},{2,0},{3,1},{3,2}};
    	int[] order = findOrder_bfs(numCourses, prerequisites);
    	for(int c: order) System.out.println(c);
    }
}