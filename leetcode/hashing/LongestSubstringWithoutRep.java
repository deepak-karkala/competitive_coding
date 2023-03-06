/*
3. Longest Substring Without Repeating Characters
Medium
32.5K
1.4K
Companies
Given a string s, find the length of the longest 
substring
 without repeating characters.
*/

import java.util.*;

public class LongestSubstringWithoutRep {
	/*
	private static int lengthOfLongestSubstring(String s) {
		if (s==null || s.length()==0) return 0;
		HashSet<Character> set = new HashSet<Character>();
		int maxlen = 0;

		for(char ch: s.toCharArray()){
			if (set.contains(ch)) {
				if (set.size() > maxlen) maxlen = set.size();
				set = new HashSet<Character>();
			}
			set.add(ch);
		}
		return Math.max(maxlen, set.size());
	}
	*/

	/*
	Approach - hash map
		Iterate through string, keep hash map of character and its index as value. 
			Use left and right pointers (i) to track substring
		If repeated character, update left pointer to (index of last occurrence of repeated character+1).
			Watch out, there are edge cases here, left pointer should only be updated if it moves to right,
				it should not move towards left !!!
		Keep track of length as i - left_pointer.
	*/
	private static int lengthOfLongestSubstring(String s) {
		if (s==null || s.length()==0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxlen = 0;
		int startIdx = 0, i = 0;

		for(i=0; i<s.length(); i++) {
			char ch = s.charAt(i);

			if(map.containsKey(ch)) {
				int currlen = (i-1) - startIdx + 1;
				if (currlen > maxlen) maxlen = currlen;
				startIdx = Math.max(startIdx, map.get(ch)+1);
			}
			map.put(ch, i);
		}
		return Math.max(maxlen, i-startIdx);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}