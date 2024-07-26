"""
392. Is Subsequence
Solved
Easy
Topics
Companies
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
"""


class IsSubsequence:
    def isSubsequence(self, s: str, t: str) -> bool:
        ptrS, ptrT = 0, 0

        while ptrS < len(s) and ptrT < len(t):
            if s[ptrS] == t[ptrT]:
                ptrS += 1
            ptrT += 1

        return ptrS == len(s)
