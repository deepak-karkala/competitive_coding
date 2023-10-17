/*
345. Reverse Vowels of a String
Easy
Topics
Companies
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
*/

class ReverseVowels {
    private static String reverseVowels(String s) {
        int low = 0;
        int high = s.length()-1;
        char[] charr = s.toCharArray();

        while(low < high) {
        	if (isVowel(charr[low]) && isVowel(charr[high])) {
        		char tmp = charr[high];
        		charr[high] = charr[low];
        		charr[low] = tmp;
        		low++; high--;
        	} else if (isVowel(charr[low]) && !isVowel(charr[high])) {
        		high--;
        	} else if (!isVowel(charr[low]) && isVowel(charr[high])) {
        		low++;
        	} else {
        		low++; high--;
        	}

        }

        return String.valueOf(charr);
    }

    private static boolean isVowel(char c) {
    	return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }

    public static void main(String[] args) {
    	String s = "leetcode";
    	System.out.println(reverseVowels(s));
    }
}