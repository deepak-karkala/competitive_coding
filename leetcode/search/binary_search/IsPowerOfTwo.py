"""
231. Power of Two
Solved
Easy
Topics
Companies
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

"""


class IsPowerOfTwo:
    def isPowerOfTwo(self, n: int) -> bool:
        """
        x = 1
        while x < n:
            x *= 2
        # On loop exit x >= n
            # If x == n, then n is a power of 2
            # If x > n, then n is not a power of 2
        return x == n
        """
        return (n > 0) and (n & (n - 1)) == 0
