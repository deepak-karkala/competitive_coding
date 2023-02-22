/*
78. Subsets
Medium
13.6K
191
Companies
Given an integer array nums of unique elements, return all possible 
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/

import java.util.*;

public class Subsets {
	/*
	Approach - recursive - top down
		Base case - For length 1, subset = [[], [elem]]
		For nth element, get subsets of n-1 first elements of array, then in addition to
			those subsets, add new subsets by adding nth element to each subset
	*/
	public static List<List<Integer>> subsetsRecursive(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets = generateSubsetsRecursive(nums, nums.length);
		return subsets;
	}

	public static List<List<Integer>> generateSubsetsRecursive(int[] nums, int n) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		// Base case
		if (n==0) {
			subsets.add(new ArrayList<Integer>());
			return subsets;
		}

		subsets = generateSubsetsRecursive(nums, n-1);

		// New item to be added
		int item = nums[n-1];
		// newSubsets will contain subsets with nth element (item)
		List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();
		for(List<Integer> subset: subsets) {
			List<Integer> newSubset = new ArrayList<Integer>();
			newSubset.addAll(subset);
			newSubset.add(item);
			newSubsets.add(newSubset);
		}
		subsets.addAll(newSubsets);

		return subsets;
	}

	/*Iterative - bottom up - beats 100%*/
	public static List<List<Integer>> subsetsIterative(int[] nums) {
		List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();

		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<Integer>());
		allSubsets.addAll(subsets);

		for(int i=0; i<nums.length; i++) {
			List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();

			for(List<Integer> subset: allSubsets) {
				List<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(nums[i]);
				newSubsets.add(newSubset);
			}
			allSubsets.addAll(newSubsets);
		}
		return allSubsets;
	}

	/* Iterative simplified */
	public static List<List<Integer>> subsetsIterativeSimplified(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<>());

		for(int n: nums) {
			int size = subsets.size();
			for(int i=0; i<size; i++){
				List<Integer> subset = new ArrayList<Integer>(subsets.get(i));
				subset.add(n);
				subsets.add(subset);
			}
		}
		return subsets;
	}


	/* Backtracking */
	/*
	Backtracking Eg: {1,2,3}
		Go down all the paths, start with empty set
		At first level, paths are [1], [2], [3]
			Path/tree of [1]  - will contain all subsets with the element [1]
			Path/tree of [2]  - will contain all subsets with the element [2] but not [1]
			Path/tree of [3]  - will contain all subsets with the element [3] but not [1] and not [2]
		At each level on the way down, add the subset to the final result.
		On return on the way up, remove the last element added since the parallel path will not
			contain that element anymore.
	*/
	public static List<List<Integer>> subsetsBacktrack(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		backtrack(subsets, new ArrayList<Integer>(), nums, 0);
		return subsets;
	}

	public static void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
		subsets.add(new ArrayList<>(subset));
		for(int i=start; i<nums.length; i++) {
			subset.add(nums[i]);
			backtrack(subsets, subset, nums, i+1);
			subset.remove(subset.size() - 1);
		}
	}


	/* Alternate backtracking solution - generates different tree than the above */
	public static List<List<Integer>> subsetsBacktrack2(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		backtrack2(subsets, new ArrayList<Integer>(), nums, 0);
		return subsets;
	}
	public static void backtrack2(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
		/* Recursion base case (leaf node), this is where all the valid
		subsets are present, add to final result */
		if (index == nums.length) {
			subsets.add(new ArrayList<>(subset));
			return;
		}

		/* Two branches at every node
			1 - nth element is picked
			2 - nth element is not picked */
		// 1st branch
		subset.add(nums[index]);
		backtrack2(subsets, subset, nums, index+1);
		subset.remove(subset.size()-1);

		// 2nd branch
		backtrack2(subsets, subset, nums, index+1);
		return;
	}


	/* Combinatorics / Bit manipulation */
	public static List<List<Integer>> subsetsBitManipulation(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		int numSubsets = 1<<nums.length;

		for(int i=0; i<numSubsets; i++) {
			List<Integer> subset = new ArrayList<Integer>();
			
			for(int j=0; j<nums.length; j++) {
				if ( (i & (1<<j)) != 0)	subset.add(nums[j]);
			}

			/*
			int index = 0;
			for(int k=i; k>0; k=k>>1) {
				if ((k & 1)==1) subset.add(nums[index]);
				index++;
			}*/
			subsets.add(subset);
		}
		return subsets;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> subsets = subsetsBitManipulation(nums);
		System.out.println(subsets);
	}
}