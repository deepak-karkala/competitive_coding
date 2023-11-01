/*
205. Isomorphic Strings
Easy
Topics
Companies
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving
the order of characters. No two characters may map to the same character, but a character
may map to itself.
*/
import java.util.*;

class IsomorphicStrings {
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> hmap = new HashMap<>();
        HashSet<Character> hset = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
        	if (!hmap.containsKey(s.charAt(i))) {
        		if (!hset.add(t.charAt(i))) return false;
	        	hmap.put(s.charAt(i), t.charAt(i));
	       	} else {
	       		if (hmap.get(s.charAt(i)) != t.charAt(i)) return false;
	       	}
        }
        return true;
    }

    /*
    	1. Map the characters in both strings to index where it last appeared
    	2. Keep checking if these indices are the same for both strings s and t
    	3. Return false when there is a mismatch
    */
    private static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];

        for(int i=0; i<s.length(); i++) {
        	if (arr1[s.charAt(i)] != arr2[t.charAt(i)]) return false;
        	arr1[s.charAt(i)] = i + 1;
        	arr2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
    	String s = "paper", t = "title";
    	System.out.println(isIsomorphic2(s, t));
    }
}