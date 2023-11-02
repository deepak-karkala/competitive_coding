/*
1657. Determine if Two Strings Are Close
Medium
Topics
Companies
Hint
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise
*/
import java.util.*;

class CloseStrings {
	/*
	1. Operation1 => Strings can be re-ordered => Sorted
	2. Operation2 => Number of occurrences of different characters should be same for two strings
	*/
    private static boolean closeStrings(String word1, String word2) {
    	if (word1.length() != word2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(char c: word1.toCharArray()) count1[c - 'a']++;
        for(char c: word2.toCharArray()) count2[c - 'a']++;

        // If there is a character in one string but not in another, then return false
        for(int i=0; i<count1.length; i++) {
        	if (count1[i] == count2[i]) continue;
        	if (count1[i]==0 || count2[i]==0) return false;
        }

        // Number of occurrences of different characters should be same for two strings
        Arrays.sort(count1);
        Arrays.sort(count2);

        for(int i=0; i<count1.length; i++) 
        	if (count1[i] != count2[i]) return false;

       	return true;
    }

    public static void main(String[] args){
    	String word1 = "cabbba", word2 = "abbccc";
    	System.out.println(closeStrings(word1, word2));
    }
}