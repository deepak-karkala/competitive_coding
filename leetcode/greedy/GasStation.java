/*
134. Gas Station
Medium
10.6K
897
Companies
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around
the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is
guaranteed to be unique
*/


class GasStation {


	// Approach: Brute force
	// Time: O(n^2) Space:O(1)
	private static int gasStation_bruteforce(int[] gas, int[] cost) {
		// If total cost > total gas, no solution
		int total_gas = 0, total_cost=0;
		for(int g: gas) total_gas += g;
		for(int c: cost) total_cost += c;
		if (total_gas < total_cost) return -1;

		int n = gas.length;
		for(int i=0; i<n; i++) {
			if (gas[i] < cost[i]) continue;

			int num_stations = 0;
			int curr_gas = 0, j=i;
			while (num_stations < n) {
				curr_gas += gas[j%n] - cost[j%n];
				if (curr_gas < 0) break;
				num_stations++;
				j++;
			}

			if (num_stations==n && curr_gas>=0) return i;
		}
		return -1;
	}

	// Approach: Optimised (=== Max sum subarray (Kadane's algorithm))
	// Time: O(n) Space:O(1)
	private static int gasStation_optimised(int[] gas, int[] cost) {
		// If total cost > total gas, no solution
		int total_gas = 0, total_cost=0;
		for(int g: gas) total_gas += g;
		for(int c: cost) total_cost += c;
		if (total_gas < total_cost) return -1;

		int curr_gas=0, start_idx=0;
		total_gas=0;
		for(int i=0; i<gas.length; i++) {
			curr_gas += gas[i] - cost[i];
			total_gas += gas[i] - cost[i];
			// When current_gas becomes negative, start over from next
			// station with 0 gas
			if (curr_gas < 0) {
				curr_gas = 0;
				start_idx = i + 1;
			}
		}

		return total_gas>=0 ? start_idx : -1;

	}

	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int start = gasStation_optimised(gas, cost);
		System.out.println(start);
	}
}