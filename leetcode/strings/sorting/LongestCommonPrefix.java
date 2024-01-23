/*
14. Longest Common Prefix
Solved
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
*/

import java.util.*;

class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int idx = 0;

        while(idx < first.length() && idx < last.length()) {
        	if (first.charAt(idx) == last.charAt(idx)) idx++;
        	else break;
        }
        return first.substring(0, idx);
    }

    public static void main(String[] args) {
    	String[] strs = {"flower","flow","flight"};
    	System.out.println(longestCommonPrefix(strs));
    }
}