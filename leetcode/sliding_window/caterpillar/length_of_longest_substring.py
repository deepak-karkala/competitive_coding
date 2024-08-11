"""
3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
Companies
Hint
Given a string s, find the length of the longest 
substring
without repeating characters.
"""


class LengthOfLongestSubstring:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxLen = 0
        left = 0
        hset = set()

        for right in range(len(s)):
            while s[right] in hset:
                hset.remove(s[left])
                left += 1
            hset.add(s[right])
            maxLen = max(maxLen, right - left + 1)

        return maxLen
