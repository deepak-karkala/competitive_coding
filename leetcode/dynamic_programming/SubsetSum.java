/*
Given an array of non-negative integers and an integer sum. We have to tell whether there
exists any subset in an array whose sum is equal to the given integer sum.
*/
import java.util.*;

class SubsetSum {

	// Method: Recursive
	// Time: O(2^n)
	private static boolean subsetsum_recursive_top(int[] arr, int sum){
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		int len = arr.length;
		List<Integer> subset = new ArrayList<Integer>();
		return subsetsum_recursive(arr, len, sum, subset, subsets);
	}

	private static boolean subsetsum_recursive(int[] arr, int n, int remaining_sum, List<Integer> subset, List<List<Integer>> subsets) {
		// Base case
		// We get to remaining_sum = 0 => there is a subset with desired sum.
		if (remaining_sum == 0) {
			subsets.add(new ArrayList<>(subset));
			System.out.println(subsets);
			return true;
		}
		// We got to first element without remaining_sum being 0 => No subet with desired sum
		if (n == 0) return false;

		if (arr[n-1] > remaining_sum) {
			return subsetsum_recursive(arr, n-1, remaining_sum, subset, subsets);
		} 

		boolean isSubsetWithSum1 = subsetsum_recursive(arr, n-1, remaining_sum, subset, subsets);
		subset.add(arr[n-1]);
		boolean isSubsetWithSum2 = subsetsum_recursive(arr, n-1, remaining_sum-arr[n-1], subset, subsets);
		subset.remove(subset.size()-1);
		return isSubsetWithSum1 || isSubsetWithSum2;
	}

	// Method 2: DP: Recursive with top down
	private static boolean subsetsum_dp_memo_top(int[] arr, int sum) {
		int n = arr.length;
		int[][] memo = new int[n+1][sum+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				memo[i][j] = -1;
			}
		}
		return subsetsum_dp_memo(arr, n, sum, memo);
	}

	private static boolean subsetsum_dp_memo(int[] arr, int n, int remaining_sum, int[][] memo) {
		// DP: Return memoized value
		if (memo[n][remaining_sum] != -1){
			return memo[n][remaining_sum] == 1;	
		} 

		if (remaining_sum == 0) return true;
		if (n == 0) return false;

		if (arr[n-1] > remaining_sum) {
			boolean is_subset_sum = subsetsum_dp_memo(arr, n-1, remaining_sum, memo);
			if (is_subset_sum) memo[n][remaining_sum] = 1;
			else memo[n][remaining_sum] = 0;
			return is_subset_sum;
		}

		boolean is_subset_sum = subsetsum_dp_memo(arr, n-1, remaining_sum, memo) || 
			subsetsum_dp_memo(arr, n-1, remaining_sum-arr[n-1], memo);
		if (is_subset_sum) memo[n][remaining_sum] = 1;
		else memo[n][remaining_sum] = 0;
		return is_subset_sum;
	}

	public static void main(String[] args){
		//int[] arr = {3, 34, 4, 12, 5, 2, 7, 1};
		int[] arr = {1, 2, 35};
		int sum = 10;
		boolean isSubsetWithSum = subsetsum_dp_memo_top(arr, sum);
		System.out.println(isSubsetWithSum);
	}
}