/*
1768. Merge Strings Alternately
Easy
Topics
Companies
Hint
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
*/

class MergeAlternately {
    private static String mergeAlternately(String word1, String word2) {
        int idx1 = 0, idx2 = 0, writeIdx = 0;
        char[] charr = new char[word1.length() + word2.length()];

        while(idx1 < word1.length() && idx2 < word2.length()) {
        	if (writeIdx % 2 == 0) charr[writeIdx] = word1.charAt(idx1++);
        	else charr[writeIdx] = word2.charAt(idx2++);
        	writeIdx++;
        }

        while(idx1 < word1.length()) charr[writeIdx++] = word1.charAt(idx1++);
        while(idx2 < word2.length()) charr[writeIdx++] = word2.charAt(idx2++);

        return String.valueOf(charr);
    }

    public static void main(String[] args) {
    	String word1 = "ab", word2 = "pqrs";
    	String s = mergeAlternately(word1, word2);
    	System.out.println(s);
    }
}