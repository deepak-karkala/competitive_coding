"""
67. Add Binary
Solved
Easy
Topics
Companies
Given two binary strings a and b, return their sum as a binary string.
"""


class AddBinary(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        i, j = len(a) - 1, len(b) - 1
        sum, carry = 0, 0
        res = ""

        while i >= 0 or j >= 0:
            bitA = 0 if i < 0 else ord(a[i]) - ord("0")
            bitB = 0 if j < 0 else ord(b[j]) - ord("0")

            total = (bitA + bitB + carry) % 2
            carry = (bitA + bitB + carry) // 2
            res = str(total) + res

            i, j = i - 1, j - 1

        if carry:
            res = "1" + res

        return res
