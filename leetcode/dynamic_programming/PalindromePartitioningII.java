/*
132. Palindrome Partitioning II
Solved
Hard
Topics
Companies
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
.

Return the minimum cuts needed for a palindrome partitioning of s.
*/

class PalindromePartitioningII {
    /*
    Recursion
    1. Cut at each point, min cuts needed = min_cut_left + min_cut_right
    2. For s[0:j] if s[i:j] is a palindrome then memo[j] = memo[i-1] + 1
    3. Consider for possible i for each j. Find min of all those splits
    */
    public int minCut(String s) {
        // memo[i] -> min cuts needed for each partition in s[0:i] to be a palindrome
        int[] memo = new int[s.length()];

        // s[0:i) -> min cuts needed = i
        for(int i = 0; i < s.length(); i++) memo[i] = i;

        // Grow the palindrome with each i as center
        for(int i = 0; i < s.length(); i++) {
            // Odd length, center character: s[i]
            dp(s, memo, i, i);
            // Even length, center characters: s[i] and s[i+1]
            dp(s, memo, i, i + 1);
        }
        return memo[s.length() - 1];
    }

    public void dp(String s, int[] memo, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            // s[0: end] is a palindrome, 0 cuts needed
            if (start == 0) {
                memo[end] = 0;
            } else {
                memo[end] = Math.min(memo[end], memo[start - 1] + 1);
            }
            start--;
            end++;
        }
        return;
    }
}