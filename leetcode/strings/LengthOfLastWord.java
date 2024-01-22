/*
58. Length of Last Word
Solved
Easy
Topics
Companies
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
 */

 class LengthOfLastWord {
    private static int lengthOfLastWord(String s) {
        int idx = s.length() - 1;
        int len = 0;

        // Skip all whitespaces at the end of 
        while(idx>=0 && s.charAt(idx) == ' ') idx--; 
        // Count the number of consecutive non-whitespace characters
        while(idx>=0 && s.charAt(idx) != ' ') {idx--; len++;}
        return len;
    }

    public static void main(String[] args) {
    	String s = "   fly me   to   the moon  ";
    	System.out.println(lengthOfLastWord(s));
    }
}