/*
Given a Knapsack/Bag with W weight capacity and a list of N items
with given vi value and wi weight. Put these items in the knapsack
in order to maximise the value of all the placed items without
exceeding the limit of the Knapsack.
*/

class Knapsack01 {

	// Method 1
	// Recursive brute force
	// There are a total of 2^n ways of choosing n items
	// => O(2^n)
	private static int knapsack_recursive_bf_top(int[] v, int[] w, int W) {
		int n = v.length-1;
		return knapsack_recursive_bf(v, w, W, n);
	}

	private static int knapsack_recursive_bf(int[] v, int[] w, int W, int n) {
		// Base case
		if (n<0 || W==0) return 0;

		// If current item's weight is less than remaining weight, there are 2 options
		//	a. Either pick this item and update remaining weight accordingly
		//	b. Don't pick this iteam and remaining weight remains same
		// We need to choose max of these 2 options
		if (w[n] < W) {
			return Math.max(v[n] + knapsack_recursive_bf(v, w, W-w[n], n-1), knapsack_recursive_bf(v, w, W, n-1));
		}
		// If current item's weight is more than remaining weight, we cannot choose this item,
		//return the best value with n-1 items
		return knapsack_recursive_bf(v, w, W, n-1);
	}

	// Method 2
	// DP: Top down memoization
	// There are a total of N * W unique subproblems to be solved
	// => Time: O(N * W), Space: O(N * W)
	private static int knapsack_dp_memo_top(int[] v, int[] w, int W) {
		int n = v.length-1;
		int[][] memo = new int[n+1][W+1];
		for(int i=0; i<=n; i++){
			for(int j=0; j<=W; j++){
				memo[i][j] = -1;
			}
		}
		return knapsack_dp_memo(v, w, W, n, memo);
	}

	private static int knapsack_dp_memo(int[] v, int[] w, int W, int n, int[][] memo) {
		// Base Case
		if (n<0 || W==0) return 0;

		// Return memoized value if computed previously
		if (memo[n][W] != -1) return memo[n][W];

		// If current item's weight is less than weight remaining,
		if (w[n] < W) {
			return memo[n][W] = Math.max(v[n] + knapsack_dp_memo(v, w, W-w[n], n-1, memo), knapsack_dp_memo(v, w, W, n-1, memo));
		}

		// If current item's weight is more than weight remaining, this item cannot be picked,
		return memo[n][W] = knapsack_dp_memo(v, w, W, n-1, memo);
	}


	public static void main(String[] args) {
		int[] v = {10, 20, 30, 40};
		int[] w = {30, 10, 40, 20};
		int W = 40;
		int max_value = knapsack_dp_memo_top(v, w, W);
		System.out.println(max_value);
	}
}