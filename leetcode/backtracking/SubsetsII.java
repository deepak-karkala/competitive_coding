/*
90. Subsets II
Medium
7.6K
216
Companies
Given an integer array nums that may contain duplicates, return all possible 
subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
*/

import java.util.*;

public class SubsetsII {
	public static List<List<Integer>> subsetsIIBacktrack(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		subsetsIIBacktrackRecursive(subsets, new ArrayList<Integer>(), nums, 0);
		return subsets;
	}

	public static void subsetsIIBacktrackRecursive(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
		subsets.add(new ArrayList<>(subset));
		for(int i=start; i<nums.length; i++) {
			if (i>start && nums[i]==nums[i-1]) continue;
			subset.add(nums[i]);
			subsetsIIBacktrackRecursive(subsets, subset, nums, i+1);
			subset.remove(subset.size()-1);
		}
		return;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 3};
		List<List<Integer>> subsets = subsetsIIBacktrack(nums);
		System.out.println(subsets);
	}
}