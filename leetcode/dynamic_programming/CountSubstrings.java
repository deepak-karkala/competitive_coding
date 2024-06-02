/*
647. Palindromic Substrings
Medium
Topics
Companies
Hint
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.
*/

class CountSubstrings {
	// DP
    public int countSubstrings(String s) {
        int n = s.length();
        // Store if string starting from i to j is a palindrome
        boolean[][] palindrome = new boolean[n][n];
        int count = 0;

        // All strings of len 1 is a palindrome
        for(int i = 0; i < n; i++) {palindrome[i][i] = true; count++; }

        // All strings of len 2 are palindrome if they are both same chars
        for(int i = 0; i < n - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1)) {palindrome[i][i + 1] = true; count++;}

        // DP: Bottom up, use len 1 and len 2 info to check if palindrome
        //      for len >= 3. First get all len 3, then len 4 and so on
        for(int len = 3; len <= n; len++)
            for(int start = 0; start < n - len + 1; start++) {
                if (palindrome[start + 1][start + len - 2] && s.charAt(start) == s.charAt(start + len - 1)) {
                    palindrome[start][start + len - 1] = true;
                    count++;
                }
            }

        return count;
    }

    // Non DP
    public int countSubstrings2(String s) {
        int count = 0;

        // Count number of palindromes with each i as centre character
        for(int i = 0; i < s.length(); i++) {
            // (Odd len) count number of palindromes with ith char as centre
            count += extendPalindrome(s, i, i);
            // (Even len) count number of palindromes with i and i+1 as two centre chars
            count += extendPalindrome(s, i, i + 1);
        }

        return count;
    }

    public int extendPalindrome(String s, int i, int j) {
        int count = 0;

        while(i >= 0 && j < s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }
}