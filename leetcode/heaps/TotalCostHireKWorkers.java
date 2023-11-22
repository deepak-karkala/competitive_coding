/*
2462. Total Cost to Hire K Workers
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.
*/
import java.util.*;


class TotalCostHireKWorkers {
	/*
	Intuition:
		To Intuition is to maintains two priority queues (pq1 and pq2) that store the candidates smallest
			costs from the beginning and end of the list.
		In each iteration, the code compares the smallest costs from pq1 and pq2 and selects the one with the
			lowest value. The corresponding cost is added to the total cost (ans), and the element is removed
			from the respective priority queue.
		This process continues for k iterations, and at the end, the accumulated ans value represents the
			minimum total cost required to hire k workers.
	*/
    private static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int leftIndex = 0;
        int rightIndex = costs.length - 1;

        long totalCost = 0;

        while(k-- > 0) {
        	while(left.size() < candidates && leftIndex <= rightIndex) left.offer(costs[leftIndex++]);
        	while(right.size() < candidates && leftIndex <= rightIndex) right.offer(costs[rightIndex--]);


        	int leftMin = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
        	int rightMin = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

        	if (leftMin <= rightMin) {
        		totalCost += left.poll();
        	} else {
        		totalCost += right.poll();
        	}
        }

        return totalCost;
    }

    public static void main(String[] args) {
		int[] costs = {17,12,10,2,7,2,11,20,8};
		int k = 3;
		int candidates = 4;
		System.out.println(totalCost(costs, k, candidates));
    }
}