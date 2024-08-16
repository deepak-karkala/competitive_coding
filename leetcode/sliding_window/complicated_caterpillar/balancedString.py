"""
1234. Replace the Substring for Balanced String
Solved
Medium
Topics
Companies
Hint
You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.

A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
"""


class BalancedString:
    def balancedString(self, s: str) -> int:
        count = collections.Counter(s)
        minLen = len(s)
        k = len(s) / 4
        left = 0

        for right in range(len(s)):
            count[s[right]] -= 1

            while left < len(s) and all(count[ch] <= k for ch in "QWER"):
                minLen = min(minLen, right - left + 1)
                count[s[left]] += 1
                left += 1

        return minLen
