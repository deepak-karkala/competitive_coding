/*
1234. Replace the Substring for Balanced String
Medium
Topics
Companies
Hint
You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.

A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0
*/

class BalancedString {
	/*
		Approach: Sliding window, 2 pointers template
		1. Count number of occurrences of all 4 characters
		2. Keep moving right pointer until window becomes valid,
			Count of any 1 character outside the window should be more than k
			(it means, there is no substring in this window which can be replaced to make string balanced)
		3. When the count all characters outside the window are less than k,
			(it means, there is a substring in this window which can be replaced)
			then move left pointer, updating min length, until window becomes invalid
		Time: O(n) Space: O(1)
	*/
    private static int balancedString(String s) {
        int[] count = new int[128];
        int start = 0, res = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++) count[s.charAt(i)]++;
        int k = s.length() / 4;

        for(int end=0; end<s.length(); end++) {
        	count[s.charAt(end)]--;

        	while(start<s.length() && count['Q']<=k && count['W']<=k && count['E']<=k && count['R']<=k) {
        		res = Math.min(res, end - start + 1);
        		count[s.charAt(start)]++;
        		start++;
        	}
        }
        return res;
    }

    public static void main(String[] args) {
    	String s = "QQQW";
    	System.out.println(balancedString(s));
    }
}