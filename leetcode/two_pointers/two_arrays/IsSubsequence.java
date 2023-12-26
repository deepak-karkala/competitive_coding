/*
392. Is Subsequence
Easy
Topics
Companies
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not)
*/

class IsSubsequence {
	/*
	Approach: 2 pointers, two arrays
	Time: O(n) Space:O(1)
	*/
    private static boolean isSubsequence(String s, String t) {
    	if (s.length() == 0) return true;
    	if (t==null || t.length() == 0) return false;

        int ptr1 = 0, ptr2 = 0;

        while(ptr2 < t.length()) {
        	char c1 = s.charAt(ptr1);
        	char c2 = t.charAt(ptr2);

        	if (c1 == c2) ptr1++;
        	if (ptr1 == s.length()) return true;
        	ptr2++;
        }

        return false;
    }

    public static void main(String[] args){
    	String s = "abc", t = "ahbgdc";
    	System.out.println(isSubsequence(s, t));
    }
}