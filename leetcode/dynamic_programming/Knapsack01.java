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
	// DP: Top down memoization (out of 2^n total subproblems, many are overlapping)
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

	// Method 3
	// DP: Bottom up iterative
	// There are a total of N * W unique subproblems to be solved
	// => Time: O(N * W), Space: O(N * W)
	private static int knapsack_dp_iterative(int[] v, int[] w, int W) {
		int n = v.length;
		int[][] memo = new int[n+1][W+1];

		// If W==0, (weight entirely used up) then for all n, memo[n][0] = 0
		for(int i=0; i<=n; i++) memo[i][0] = 0;
		// If n==0, (no items left to be picked), then for all W, memo[0][W] = 0
		for(int j=0; j<=W; j++) memo[0][j] = 0;

		for(int i=1; i<=n; i++){
			for(int j=1; j<=W; j++) {

				// If current item's weight is less than remaining weight, 2 options,
				// Either pick current item or ignore. Use max of these 2 options
				if (w[i-1] <= j) {
					memo[i][j] = Math.max(v[i-1] + memo[i-1][j-w[i-1]], memo[i-1][j]);
				} else {
				// If current item's weight is more than remaining weight, cannot choose
				// this item => optimal value is same as with n-1 items with W weight
					memo[i][j] = memo[i-1][j];	
				}
			}
		}
		return memo[n][W];
	}

	// Method 4
	// DP: Bottom up iterative with space optimized
	// To calculate optimal value for n, we only need n-1th row
	// => Instead of 2D array (Table), only 1D array is enough
	// => Time: O(N * W), Space: O(W)
	private static int knapsack_dp_iterative_spaceoptimised(int[] v, int[] w, int W) {
		int n = v.length;
		int[] memo = new int[W+1];

		// If n==0, (no items left to be picked), then for all W, memo[0][W] = 0
		for(int j=0; j<=W; j++) memo[j] = 0;

		for(int i=1; i<=n; i++){
			for(int j=W; j>=w[i-1]; j--) {

				// If current item's weight is less than remaining weight, 2 options,
				// Either pick current item or ignore. Use max of these 2 options
				//if (w[i-1] <= j) {
					memo[j] = Math.max(v[i-1] + memo[j-w[i-1]], memo[j]);
				//}

				// If current item's weight is more than remaining weight, cannot choose
				// this item => optimal value is same as with n-1 items with W weight
				// => No update required in 1D array.
				//} else {
				//	memo[i][j] = memo[i-1][j];	
				//}
			}
		}
		return memo[W];
	}

	public static void main(String[] args) {
		int[] v = {10, 20, 30, 40};
		int[] w = {30, 10, 40, 20};
		int W = 40;
		int max_value = knapsack_dp_iterative_spaceoptimised(v, w, W);
		System.out.println(max_value);
	}
}