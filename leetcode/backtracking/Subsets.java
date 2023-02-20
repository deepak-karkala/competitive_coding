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

	/*Iterative - bottom up*/
	public static List<List<Integer>> subsetsIterative(int[] nums) {
		List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();

		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<Integer>());
		allSubsets.addAll(subsets);

		for(int i=1; i<=nums.length; i++) {
			List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();

			for(List<Integer> subset: allSubsets) {
				List<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(nums[i-1]);
				newSubsets.add(newSubset);
			}
			allSubsets.addAll(newSubsets);
		}
		return allSubsets;
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> subsets = subsetsIterative(nums);
		System.out.println(subsets);
	}
}