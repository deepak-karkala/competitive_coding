/*
409. Longest Palindrome
Easy
Topics
Companies
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/

import java.util.*;

class LongestPalindrome {
    private static int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for(char ch: s.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		boolean isOdd = false;
		int longestLen = 0;
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			int count = entry.getValue();
			if (count%2!=0) {isOdd = true; longestLen += count - 1;}
			else longestLen += count;
		}
		return isOdd ? longestLen+1: longestLen;
    }

    public static void main(String[] args) {
    	String s = "a";
    	System.out.println(longestPalindrome(s));
    }

}