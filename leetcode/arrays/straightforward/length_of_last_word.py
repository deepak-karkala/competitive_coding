"""
58. Length of Last Word
Solved
Easy
Topics
Companies
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.
"""


class LengthOfLastWord:
    def lengthOfLastWord(self, s: str) -> int:
        # return len(s.split()[-1])
        lenLast = 0

        for i in s[::-1]:
            if i == " ":
                if lenLast > 0:
                    return lenLast
            else:
                lenLast += 1

        return lenLast
