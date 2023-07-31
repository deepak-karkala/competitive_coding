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
		System.out.println(wordBreak_dp_memo(s, wordDict));
	}
}