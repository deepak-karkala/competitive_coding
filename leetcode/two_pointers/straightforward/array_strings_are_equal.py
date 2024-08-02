"""
1662. Check If Two String Arrays are Equivalent
Solved
Easy
Topics
Companies
Hint
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.
"""


class ArrayStringsAreEqual:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        for w1, w2 in zip(self.generate(word1), self.generate(word2)):
            if w1 != w2:
                return False
        return True

    def generate(self, wordList):
        for word in wordList:
            for ch in word:
                yield ch
        yield None
