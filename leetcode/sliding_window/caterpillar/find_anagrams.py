"""
438. Find All Anagrams in a String
Solved
Medium
Topics
Companies
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
"""


class findAnagrams:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hmap = defaultdict(int)
        left = 0
        res = []

        for i in range(len(p)):
            hmap[p[i]] += 1

        for right in range(len(s)):
            hmap[s[right]] -= 1

            if right - left + 1 == len(p):
                if all(v == 0 for v in hmap.values()):
                    res.append(left)
                hmap[s[left]] += 1
                left += 1

        return res
