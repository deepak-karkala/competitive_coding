"""
Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.
Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
"""

import pytest


class Solution:
    def length_of_longest_substring(self, s: str) -> int:
        return -1


if __name__ == "__main__":
    sol = Solution()
    predicted = sol.length_of_longest_substring("pwwkew")
    print(predicted)