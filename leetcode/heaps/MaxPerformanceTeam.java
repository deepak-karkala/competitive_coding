/*
1383. Maximum Performance of a Team
Hard
Topics
Companies
Hint
You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

The performance of a team is the sum of its engineers' speeds multiplied by the minimum efficiency among its engineers.

Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
*/

import java.util.*;

class MaxPerformanceTeam {
	/*
		Approach: Array sort + PQ
		1. Create pairs of (speed[i], efficiency[i])
		2. Sort these in descending order of efficiency
			(Since we would like to have max efficiency)
		3. Fill PQ with speed in descending order of efficiency
		4. Keep polling PQ for max k times
			(Amongst the engineers in PQ, max speed one will be polled first)
	*/
    private static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int maxP = 0;

        // Create engineers array (with tuple of speed, efficiency)
        int[][] engineers = new int[n][2];
        for(int i=0; i<n; i++) engineers[i] = new int[]{efficiency[i], speed[i]};
        // Sort in descending order of speed
        Arrays.sort(engineers, (a,b)->b[0]-a[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->a-b);
        int currentSumSpeed = 0;

        for(int[] engineer: engineers) {
        	heap.offer(engineer[1]);
        	currentSumSpeed += engineer[1];

        	if (heap.size() > k) currentSumSpeed -= heap.poll();
        	maxP = Math.max(maxP, currentSumSpeed * engineer[0]);
        }
        return (int) (maxP % (long)(1e9 + 7));
    }

    public static void main(String[] args) {
    	int n = 3;
    	int[] speed = {2,8,2};
    	int[] efficiency = {2,7,1};
    	int k = 2;
    	System.out.println(maxPerformance(n, speed, efficiency, k));
    }
}