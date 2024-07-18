"""
1768. Merge Strings Alternately
Solved
Easy
Topics
Companies
Hint
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
"""


class MergeAlternately:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        return "".join(
            a + b for a, b in itertools.zip_longest(word1, word2, fillvalue="")
        )

        """
        i, j = 0, 0
        res = list()
        while i < len(word1) and j < len(word2):
            res.append(word1[i])
            res.append(word2[j])
            i, j = i + 1, j + 1
        
        res.append(word1[i:])
        res.append(word2[j:])

        return ''.join(res)
        """
