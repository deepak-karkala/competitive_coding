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

	public static void main(String[] args){
		int[] arr = {3, 34, 4, 12, 5, 2, 7, 1};
		int sum = 10;
		boolean isSubsetWithSum = subsetsum_recursive_top(arr, sum);
		System.out.println(isSubsetWithSum);
	}
}