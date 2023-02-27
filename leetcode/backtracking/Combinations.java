/*
77. Combinations
Medium
5.7K
177
Companies
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

*/

import java.util.*;

public class Combinations {

	private static List<List<Integer>> combinations(int n, int k){
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		backtrack(subsets, new ArrayList<>(), n, k, 1);
		return subsets;
	}

	private static void backtrack(List<List<Integer>> subsets, List<Integer> subset, int n, int k, int start) {
		if (subset.size()==k) {
			subsets.add(new ArrayList<>(subset));
			return;
		} else {
			for(int i=start; i<=n; i++){
				subset.add(i);
				backtrack(subsets, subset, n, k, i+1);
				subset.remove(subset.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(combinations(4, 2));
	}
}