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

	public static void main(String[] args) {
		int[] v = {10, 20, 30, 50};
		int[] w = {30, 10, 40, 20};
		int W = 60;
		int max_value = knapsack_recursive_bf_top(v, w, W);
		System.out.println(max_value);
	}
}