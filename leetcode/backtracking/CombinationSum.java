/*
39. Combination Sum
Medium
15.2K
301
Companies
Given an array of distinct integers candidates and a target integer target, return a
list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations
are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to
target is less than 150 combinations for the given input.
*/
import java.util.*;

public class CombinationSum {

	private static List<List<Integer>> combinationSumBacktrack(int[] candidates, int target) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		backtrack(subsets, new ArrayList<Integer>(), candidates, target, 0);
		return subsets;
	}

	private static void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] candidates, int remain, int start) {
		if (remain<0) {
			return;
		} else if (remain==0) {
			subsets.add(new ArrayList<>(subset));
		} else {
			// Backtrack
			for(int i=start; i<candidates.length; i++) {
				subset.add(candidates[i]);
				backtrack(subsets, subset, candidates, remain-candidates[i], i);
				subset.remove(subset.size()-1);
			}
		}
		return;
	}

	
	// Approach recursive
	// Given all subsets of len n-1, generate all subsets of len n
	// For every subset generated, if the sum of the elements == target, add it to final result
	private static List<List<Integer>> combinationSumRecursive(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> subsets = recurse(result, candidates, target, candidates.length);
		return result;
	}

	private static List<List<Integer>> recurse(List<List<Integer>> result, int[] candidates, int target, int level) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();

		// Base case
		if (level==1) {
			for(int num: candidates) {
				subsets.add(new ArrayList<>(Arrays.asList(num)));
				if (num == target) result.add(new ArrayList<>(Arrays.asList(num)));
			}
			return subsets;
		}

		subsets = recurse(result, candidates, target, level-1);

		for(int i=0; i<subsets.size(); i++) {
			List<Integer> subset = new ArrayList<Integer>(subsets.get(i));
			int lastElem = subset.get(subset.size()-1);
			int startIndex = findIndex(candidates, lastElem);

			// Given all subsets of len n-1, while generating subsets of len n,
			// start from the index of last elem in the subset, because the other
			// combinations would already have been explored in the earlier paths
			// => This will avoid repeated subsets(combinations).
			for(int j=startIndex; j<candidates.length; j++) {
				subset = new ArrayList<Integer>(subsets.get(i));
				subset.add(candidates[j]);
				int sum = 0;
				for(int num: subset) {
					sum += num;
				}
				if (sum == target) result.add(new ArrayList<>(subset));
				newSubsets.add(new ArrayList<>(subset));
			}
		}
		return newSubsets;
	}
	
	// Helper function to recursive approach
	private static int findIndex(int arr[], int t)
    {
        // if array is Null
        if (arr == null) return -1;
  
        // find length of array
        int len = arr.length;
        int i = 0;
  
        // traverse in the array
        while (i < len) {
            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
	

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSumRecursive(candidates, target));
	}
}