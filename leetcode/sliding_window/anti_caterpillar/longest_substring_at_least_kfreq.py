"""
395. Longest Substring with At Least K Repeating Characters
Medium
Topics
Companies
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.
"""


class LongestSubstringAtLeastKFreq:
    def longestSubstring(self, s: str, k: int) -> int:
        # For each unique char in string
        for char in set(s):
            # Check if freq of char is < k
            if s.count(char) < k:
                # If freq < k
                #   => this char can never be part of output substring
                # Split the string separated by this char and recurse in substrings
                return max(
                    self.longestSubstring(substring, k) for substring in s.split(char)
                )
        # IF freq of each char in s > k, then maxLen = len(s)
        return len(s)
