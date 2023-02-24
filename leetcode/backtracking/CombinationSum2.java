/*
40. Combination Sum II
Medium
8K
200
Companies
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
*/
import java.util.*;

public class CombinationSum2 {

	private static List<List<Integer>> combinationSum2Backtrack(int[] candidates, int target) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(subsets, new ArrayList<Integer>(), candidates, target, 0);
		return subsets;
	}

	private static void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] candidates, int remain, int start) {
		if (remain < 0) return;
		else if (remain == 0) subsets.add(new ArrayList<>(subset));
		else {
			for(int i=start; i<candidates.length; i++) {
				if (candidates[i] > target) continue;
				if (i>start && candidates[i]==candidates[i-1]) continue;
				subset.add(candidates[i]);
				backtrack(subsets, subset, candidates, remain-candidates[i], i+1);
				subset.remove(subset.size()-1);
			}
		}
		return;
	}

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2Backtrack(candidates, target));
	}
}