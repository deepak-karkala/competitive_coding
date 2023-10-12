/*
216. Combination Sum III
Medium
Topics
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice,
and the combinations may be returned in any order.
*/
import java.util.*;

class CombinationSum3 {
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        backtrack(lists, new ArrayList<>(), k, n, 1);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> list, int k, int remain, int start) {
    	if (remain < 0) {
    		return;
    	} else if (remain == 0) {
    		if (list.size() == k) lists.add(new ArrayList<>(list));
    	} else {
    		for(int i=start; i<=9; i++) {
    			if (list.size() >= k || remain-i < 0) continue;
    			list.add(i);
    			backtrack(lists, list, k, remain - i, i+1);
    			list.remove(list.size()-1);
    		}
    	}
    	return;
    }

    public static void main(String[] args) {
    	int k = 9, n = 45;
    	List<List<Integer>> lists = combinationSum3(k, n);
    	for(List<Integer> list: lists)
    		System.out.println(list);
    }
}