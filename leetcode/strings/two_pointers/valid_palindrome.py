"""
680. Valid Palindrome II
Solved
Easy
Topics
Companies
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
"""


class ValidPalindrome(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """

        def isPalindrome(s, left, right, deletes):
            numDeletesAllowed = 1
            while left < right:
                if s[left] != s[right]:
                    if deletes >= numDeletesAllowed:
                        return False
                    else:
                        return isPalindrome(
                            s, left + 1, right, deletes + 1
                        ) or isPalindrome(s, left, right - 1, deletes + 1)
                else:
                    left += 1
                    right -= 1

            return True

        return isPalindrome(s, 0, len(s) - 1, 0)
