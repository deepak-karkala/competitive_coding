/*
139. Word Break
Medium
14.7K
621
Companies
Given a string s and a dictionary of strings wordDict, return true if s can be
segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/
import java.util.*;

class WordBreak {
	// Method 1 Recursive Time: O(2^N), Space: O(N)
	private static boolean wordBreak_recursive_top(String s, List<String> wordDict) {
		return wordBreak_recursive(s, wordDict, 0);
	}

	private static boolean wordBreak_recursive(String s, List<String> wordDict, int start) {
		// Base case
		if (start == s.length()) return true;

		// Recursive structure
		// Make a split at every point and see if left substring is part of dict
		// and recurse through right substring
		for(int end=start+1; end<=s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && wordBreak_recursive(s, wordDict, end))
				return true;
		}
		return false;
	}	

	// Method 2 DP with memo Time: O(N^3), Space: O(N)
	private static boolean wordBreak_dp_memo(String s, List<String> wordDict) {
		int len = s.length();
		boolean[] memo = new boolean[len + 1];
		memo[0] = true;

		for(int i=1; i<=len; i++) {
			for(int j=0; j<i; j++) {
				if(memo[j] && wordDict.contains(s.substring(j, i))) {
					memo[i] = true;
					break;
				}
			}
		}
		return memo[len];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak_recursive_top(s, wordDict));
	}
}