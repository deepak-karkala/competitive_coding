"""
28. Find the Index of the First Occurrence in a String
Solved
Easy
Topics
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
"""


class StrStr(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(haystack) < len(needle):  # early termination
            return -1
        if not needle:
            return 0

        i, j = 0, 0

        while i < len(haystack) and j < len(needle):
            if haystack[i] == needle[j]:
                if j == 0:
                    startIdx = i
                i, j = i + 1, j + 1
                if j == len(needle):
                    return startIdx
            else:
                if j != 0:
                    i = startIdx + 1
                else:
                    i += 1
                j = 0

        return -1
