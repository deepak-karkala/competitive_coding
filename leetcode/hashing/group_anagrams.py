"""
49. Group Anagrams
Solved
Medium
Topics
Companies
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
"""


class GroupAnagrams:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        All anagrams will have same character count
        Store char counts in a list (convert to tuple), use it as key
        All anagrams will map to same char counts key, values will store actual strings
        """
        map = defaultdict(list)

        for s in strs:
            count = [0] * 26  # List(mutable) cannot be hashed (key of dict)
            for ch in s:
                count[ord(ch) - ord("a")] += 1
            # Use tuple (immutable) as key
            map[tuple(count)].append(s)

        return map.values()
