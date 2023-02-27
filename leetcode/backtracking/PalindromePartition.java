/*
131. Palindrome Partitioning
Medium
10.2K
325
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.
*/

import java.util.*;

public class PalindromePartition {
	private static List<List<String>> palindromePartitionBacktrack(String s) {
		List<List<String>> subsets = new ArrayList<List<String>>();
		backtrack(subsets, new ArrayList<String>(), s, 0);
		return subsets;
    }

    private static void backtrack(List<List<String>> subsets, List<String> subset, String s, int start) {
    	if (start == s.length()) {
    		subsets.add(new ArrayList<>(subset));
    	} else {
    		for(int i=start; i<s.length(); i++) {
    			if (isPalindrome(s, start, i)) {
    				subset.add(s.substring(start, i+1));
    				backtrack(subsets, subset, s, i+1);
    				subset.remove(subset.size()-1);
    			}
    		}
    	}
    }

    private static boolean isPalindrome(String s, int low, int high) {
    	while (low < high) {
    		if(s.charAt(low++) != s.charAt(high--)) return false;
    	}
    	return true;
    }

	public static void main(String[] args) {
		String s = "abaca";
		System.out.println(palindromePartitionBacktrack(s));
	}
}