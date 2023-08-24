/*
207. Course Schedule
Medium
14.9K
594
Companies
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/

import java.util.*;


class CourseSchedule {
	// BFS Topological Sort
	// Keep adding vertices with indegree=0 to queue and check if at the end
	//		all the vertices are visited
	// Time: O(V + E)
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list based on prerequisites and update indegrees of vertices
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) adj[i] = new ArrayList<Integer>();
        for(int i=0; i<prerequisites.length; i++) {
        	adj[prerequisites[i][1]].add(prerequisites[i][0]);
        	indegree[prerequisites[i][0]]++;
        }

        // Add vertices with indegree=0 to queue (can start with these courses)
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
        	if (indegree[i] == 0) queue.offer(i);
        }

        // Number of courses that can be completed (After having taken all its prerequisites)
        // At the end, if this is same as total courses, then return true
        int numCoursesCompleted = 0;
        while (!queue.isEmpty()) {
        	int u = queue.poll();
        	numCoursesCompleted++;

        	// Scan courses which have this course as prerequisite
        	// If all the prerequisites of that course are completed (indegree==0), then
        	// 		add that course to queue since it no longer has any more prerequisites.
        	for (int v: adj[u]) {
        		indegree[v]--;
        		if (indegree[v] == 0) queue.offer(v);
        	}
        }

        return numCoursesCompleted == numCourses;
    }

    public static void main(String[] args) {
    	int numCourses = 2;
    	int[][] prerequisites = { {1,0}, {0,1} };
    	System.out.println(canFinish(numCourses, prerequisites));
    }
}