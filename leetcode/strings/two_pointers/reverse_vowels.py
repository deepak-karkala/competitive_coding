"""
345. Reverse Vowels of a String
Solved
Easy
Topics
Companies
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
"""


class ReverseVowels(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        word = list(s)
        vowels = set(["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"])
        low, high = 0, len(s) - 1

        while low < high:
            while low < high and word[low] not in vowels:
                low += 1

            while high > low and word[high] not in vowels:
                high -= 1

            word[low], word[high] = word[high], word[low]
            low, high = low + 1, high - 1

        return "".join(word)
