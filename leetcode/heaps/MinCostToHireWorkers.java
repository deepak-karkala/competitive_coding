/*
857. Minimum Cost to Hire K Workers
Hard
Topics
Companies
There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.
*/

import java.util.*;

class MinCostToHireWorkers {
    /*
        1. For the k workers hired, ratio wage/quality should be the same according to spec
        2. We would want to choose workers in increasing order of this ratio (lowest cost to highest quality)
        3. Keep summing up the quality,
            when num workers selected == k, multiply by last worker's cost/quality
            => Last worker will be paid his specified wage
            And the other k-1 workers, will be paid according to this ratio,
                paid[i] = cost[kth]/quality[kth] * quality[i]
            This means, all the workers will be paid based on the ratio of highest cost/quality worker
        4. When num of workers exceed k,
            Use PQ to remove the worker with highest quality
        5. Keep updating the sum(wage), tracking the min of this quantity
    */
    private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[][] workers = new double[quality.length][2];
        // Ratio wage/quality
        for(int i=0; i<quality.length; i++)
            workers[i] = new double[]{ (double) wage[i]/quality[i], (double) quality[i] };
        // sort in ascending order of wage/quality
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        // Max heap, worker with highest quality at top
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a,b) -> Double.compare(b, a));

        // Current and Min sum of wage
        double currSum = 0, minSum = Double.MAX_VALUE;

        for(double[] worker: workers) {
            // Keep adding quality, once k workers are selected,
            //      Multiply by highest wage/quality of the k workers
            currSum += worker[1];
            pq.offer(worker[1]);

            // When PQ size exceeds k, remove worker with largest quality
            if (pq.size() > k) currSum -= pq.poll();
            if (pq.size() == k) minSum = Math.min(minSum, currSum * worker[0]);
        }
        return minSum;
    }

    public static void main(String[] args) {
    	int[] quality = {3,1,10,10,1};
    	int[] wage = {4,8,2,2,7};
    	int k = 3;
    	System.out.println(mincostToHireWorkers(quality, wage, k));
    }
}