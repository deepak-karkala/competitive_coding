"""
567. Permutation in String
Solved
Medium
Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
"""


class PermutationInString:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        left = 0
        hmap = defaultdict(int)
        numCharOfKeyInWin = 0

        for ch in s1:
            hmap[ch] += 1

        for right in range(len(s2)):
            if hmap[s2[right]] > 0:
                numCharOfKeyInWin += 1
            hmap[s2[right]] -= 1

            if right - left + 1 == len(s1):
                if numCharOfKeyInWin == len(s1):
                    return True

                hmap[s2[left]] += 1
                if hmap[s2[left]] > 0:
                    numCharOfKeyInWin -= 1
                left += 1

        return False
