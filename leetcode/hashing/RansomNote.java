/*
383. Ransom Note
Easy
Topics
Companies
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote
*/

class RansomNote {
    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] count = new int[26];
        for(int i=0; i<magazine.length(); i++) {
        	count[magazine.charAt(i)-'a']++;
        	if (i<ransomNote.length()) count[ransomNote.charAt(i)-'a']--;
        }

        for(int i=0; i<count.length; i++) {
        	if (count[i] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	String ransomNote = "aa", magazine = "ab";
    	System.out.println(canConstruct(ransomNote, magazine));
    }
}