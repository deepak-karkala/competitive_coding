/*
438. Find All Anagrams in a String
Medium
Topics
Companies
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
import java.util.*;

class FindAnagrams {
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s==null || p==null || s.length()<p.length()) return list;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i=0; i<p.length(); i++) count1[p.charAt(i)-'a']++;
        for(int i=0; i<p.length(); i++) count2[s.charAt(i)-'a']++;
        if (Arrays.equals(count1, count2)) list.add(0);

        int start = 0, end = 0;
        
        for(end=p.length(); end<s.length(); end++) {
            count2[s.charAt(end)-'a']++;
            count2[s.charAt(start)-'a']--;
            start++;

            if (Arrays.equals(count1, count2) && end-start+1 == p.length()) list.add(start);
        }
        return list;
    }

    public static void main(String[] args) {
    	String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        for(Integer i: list) System.out.print(i + " ");
    }
}