/*
1456. Maximum Number of Vowels in a Substring of Given Length
Medium
Topics
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/

class MaxVowels {
	/*
	Approach: Sliding window with standard 2 pointers template
	Time: O(n) Space: O(1)
	*/
    private static int maxVowels(String s, int k) {
        int start = 0, end = 0, currVowels = 0, maxVowels = 0;

        for(end=0; end<k; end++) {
        	char ch = s.charAt(end);
        	if (isVowel(ch)) currVowels++;
        }
        maxVowels = currVowels;

        for(end=k; end<s.length(); end++) {
        	char chTail = s.charAt(end);

        	if (end-start+1 > k) {
        		char chHead = s.charAt(start);

        		if (isVowel(chTail)) currVowels++;
        		if (isVowel(chHead)) currVowels--;

        		maxVowels = Math.max(maxVowels, currVowels);
        		start++;
        	}	
        }
        return maxVowels;
    }

    private static boolean isVowel(char ch) {
    	if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
    	return false;
    }

    public static void main(String[] args) {
    	String s = "abciiidef";
    	int k = 3;
    	System.out.println(maxVowels(s, k));
    }
}