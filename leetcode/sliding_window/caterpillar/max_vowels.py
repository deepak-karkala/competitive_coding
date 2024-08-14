"""
1456. Maximum Number of Vowels in a Substring of Given Length
Solved
Medium
Topics
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
"""


class MaxVowels:
    def maxVowels(self, s: str, k: int) -> int:
        left = 0
        maxVowels, currVowels = 0, 0
        vowels = ["a", "e", "i", "o", "u"]

        for right in range(len(s)):
            if s[right] in vowels:
                currVowels += 1

            if right - left + 1 == k:
                maxVowels = max(maxVowels, currVowels)
                if s[left] in vowels:
                    currVowels -= 1
                left += 1

        return maxVowels
