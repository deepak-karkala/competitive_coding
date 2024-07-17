"""
125. Valid Palindrome
Solved
Easy
Topics
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
"""


class IsPalindrome(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        alphaNumbericString = ""

        for char in s:
            if char.isalpha() or char.isdigit():
                alphaNumbericString += char.lower()

        return alphaNumbericString == alphaNumbericString[::-1]
