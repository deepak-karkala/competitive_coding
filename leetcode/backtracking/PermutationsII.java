/*
47. Permutations II
Medium
7.1K
127
Companies
Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.
*/

import java.util.*;

public class PermutationsII {
	public static List<List<Integer>> permutationsIIBacktrack(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack1(subsets, new ArrayList<>(), nums, used);
		return subsets;
	}

	private static void backtrack1(List<List<Integer>> subsets, List<Integer> subset, int[] nums, boolean[] used) {
		// Base case - leaf level
		if(subset.size() == nums.length) {
			subsets.add(new ArrayList<>(subset));
			return;
		}

		// Go through all elements, except ones which are already
		// added in the subset.
		// Avoid paths of repeated elements by checking if 
		// 		current element is same as previous and
		//		previous element has been used
		for(int i=0; i<nums.length; i++) {
			if(used[i]) continue;
			if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;

			subset.add(nums[i]);
			used[i] = true;
			backtrack1(subsets, subset, nums, used);
			used[i] = false;
			subset.remove(subset.size()-1);
		}
		return;
	}


	//private static List<List<Integer>> permutationsIIRecu



	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> subsets = permutationsIIBacktrack(nums);
		System.out.println(subsets);
	}
}