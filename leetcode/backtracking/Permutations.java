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


	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> subsets = permutationsRecursive1(nums);
		System.out.println(subsets);
	}
}