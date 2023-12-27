/*
28. Find the Index of the First Occurrence in a String
Solved
Easy
Topics
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

class StrStr {
    private static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        for(int i=0; i<=haystack.length()-needle.length(); i++) {
        	int j = 0;

        	while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j)) j++;

        	if (j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
    	String haystack = "cadbutsad", needle = "sad";
    	System.out.println(strStr(haystack, needle));
    }
}