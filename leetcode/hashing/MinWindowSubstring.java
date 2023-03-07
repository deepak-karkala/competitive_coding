/*
76. Minimum Window Substring
Hard
14.5K
618
Companies
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the
window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
*/


class MinWindowSubstring {

	/*
	Approach: Two pointer with hashing
		1. Use two pointers: start and end to represent a window.
		2. Move end to find a valid window.
		3. When a valid window is found, move start to find a smaller window.
	*/
    private static String minWindowSubstring(String s, String t) {
        if (s==null || s.length()==0 || s.length()<t.length()) return "";
        int start = 0, end = 0, minStart = 0, minLen=Integer.MAX_VALUE, counter=0;

        int[] map = new int[128]; // Assume ASCII set
        for(char c: t.toCharArray()) map[c]++;

        while(end < s.length()) {
        	// Increment right pointer
        	char c1 = s.charAt(end);
        	if (map[c1] > 0) counter++;
        	map[c1]--;
        	end++;

        	// Move the left pointer as long solution is valid
        	while(counter == t.length()) {
        		//Record the min solution if better than prev best
        		if (minLen > end-start) {
        			minLen = end - start;
        			minStart = start;
        		}
        		char c2 = s.charAt(start);
        		map[c2]++;
        		if (map[c2] > 0) counter--;
        		start++;
        	}
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }

    public static void main(String[] args) {
    	String s = "ADOBECODEBANC", t = "ABC";
    	System.out.println(minWindowSubstring(s, t));
    }
}