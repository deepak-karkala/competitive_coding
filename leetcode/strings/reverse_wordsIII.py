"""
557. Reverse Words in a String III
Solved
Easy
Topics
Companies
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
"""


class ReverseWords(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join(word[::-1] for word in s.split())
