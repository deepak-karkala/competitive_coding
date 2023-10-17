/*
541. Reverse String II
Easy
Topics
Companies
Given a string s and an integer k, reverse the first k characters for every 2k
characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less
than 2k but greater than or equal to k characters, then reverse the first k characters
and leave the other as original.

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
*/

class ReverseString2 {
    private static String reverseString2(String s, int k) {
        int left = 0;
        int right = 0;
        char[] charr = s.toCharArray();

        while(left < s.length()) {
        	// Move the right pointer to k characters ahead
        	right = Math.min(right + k, s.length());
        	// Reverse part of string from left to right
        	charr = reversePartOfString(charr, left, right-1);

        	right += k;
        	left = right;
        }

        return String.valueOf(charr);
    }

    private static char[] reversePartOfString(char[] charr, int low, int high) {
    	while(low < high) {
    		char tmp = charr[high];
    		charr[high] = charr[low];
    		charr[low] = tmp;
    		low++;
    		high--;
    	}
    	return charr;
    }

    public static void main(String[] args) {
    	String s = "abcd";
    	int k = 4;
    	System.out.println(reverseString2(s, k));
    }
}