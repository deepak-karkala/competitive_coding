/*
1358. Number of Substrings Containing All Three Characters
Medium
Topics
Companies
Hint
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c
*/

class NumberOfSubstrings3Characters {
    private static int numberOfSubstrings(String s) {
        int start = 0, res = 0;
        int[] count = {0, 0, 0};

        for(int end=0; end<s.length(); end++) {
        	count[s.charAt(end)-'a']++;

        	while(count[0]>0 && count[1]>0 && count[2]>0) {
        		count[s.charAt(start++)-'a']--;
        	}

        	res += start;
        }
        return res;
    }

    public static void main(String[] args) {
    	String s = "abcabc";
    	System.out.println(numberOfSubstrings(s));
    }
}