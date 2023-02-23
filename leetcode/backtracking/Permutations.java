/*
46. Permutations
Medium
14.8K
252
Companies
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.
*/
import java.util.*;

public class Permutations {
	public static List<List<Integer>> permutationsBacktrack1(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		backtrack1(subsets, new ArrayList<>(), nums);
		return subsets;
	}

	private static void backtrack1(List<List<Integer>> subsets, List<Integer> subset, int[] nums) {
		if (subset.size() == nums.length) {
			subsets.add(new ArrayList<>(subset));
		} else {
			for(int i=0; i<nums.length; i++) {
				if (subset.contains(nums[i])) continue;
				subset.add(nums[i]);
				backtrack1(subsets, subset, nums);
				subset.remove(subset.size()-1);
			}
		}
	}

	//Approach - recursive1 - given all permutations of first n-1 elements,
	//add new permutations with nth element.
	private static List<List<Integer>> permutationsRecursive1(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets = recursive1(nums, nums.length);
		return subsets;
	}

	private static List<List<Integer>> recursive1(int[] nums, int index) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		// Base case
		if (index==1) {
			subsets.add(new ArrayList<>(Arrays.asList(nums[0])));
			return subsets;
		}

		subsets = recursive1(nums, index-1);

		List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();
		int item = nums[index-1];

		for(int i=0; i<subsets.size(); i++) {
			List<Integer> subset = new ArrayList<Integer>(subsets.get(i));
			int numPos = subset.size() + 1;
			for(int pos=0; pos<numPos; pos++) {
				subset = new ArrayList<Integer>(subsets.get(i));
				subset.add(pos, item);
				newSubsets.add(subset);
			}
		}
		return newSubsets;
	}


	// Approach - recursive2 - given all permutations of length n-1, add
	// new permutations of len n by adding nth element
	private static List<List<Integer>> permutationsRecursive2(int[] nums) {
		return recursive2(nums, nums.length);
	}

	private static List<List<Integer>> recursive2(int[] nums, int index) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();

		if (index == 1) {
			for(int num: nums) subsets.add(new ArrayList<>(Arrays.asList(num)));
			return subsets;
		}

		// Get all permutations of length index-1
		subsets = recursive2(nums, index-1);

		// For each subset, add the remaining element(one which is not in hashset already)
		// to get permutations of length n.
		int size = subsets.size();
		for(int i=0; i<size; i++) {
			for(int j=0; j<nums.length; j++) {
			Set<Integer> subset = new LinkedHashSet<Integer>(subsets.get(i));
				if (subset.add(nums[j])) {
					newSubsets.add(new ArrayList<>(subset));
				}
			}
		}

		return newSubsets;
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> subsets = permutationsRecursive2(nums);
		System.out.println(subsets);
	}
}