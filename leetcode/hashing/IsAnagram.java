/*
242. Valid Anagram
Easy
Topics
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word
or phrase, typically using all the original letters exactly once.
*/

import java.util.*;

class IsAnagram {
    private static boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()) return false;

        int[] charCount = new int[26];

        for(char c: s.toCharArray()) charCount[c-'a']++;
        for(char c: t.toCharArray()) {
        	charCount[c-'a']--;
        	if (charCount[c-'a'] < 0) return false;
        }

        for(int i=0; i<charCount.length; i++)
        	if (charCount[i] != 0) return false;

        return true;
    }

    private static boolean isAnagramHashMap(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(char c: s.toCharArray()) hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        for(char c: t.toCharArray()) hmap.put(c, hmap.getOrDefault(c, 0)-1);

        for(char c: hmap.keySet())
        	if (hmap.get(c) != 0) return false;

        return true;
    }

    public static void main(String[] args) {
    	String s = "anagram", t = "nagaram";
    	System.out.println(isAnagramHashMap(s, t));
    }
}