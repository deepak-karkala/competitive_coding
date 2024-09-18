"""
342. Power of Four
Solved
Easy
Topics
Companies
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.


"""


class IsPowerOfFour:
    def isPowerOfFour(self, n: int) -> bool:
        if n == 1:
            return True

        if n <= 0 or n % 4:
            return False

        return self.isPowerOfFour(n // 4)

        """
        # If log4(n) returns an integer, then n is a power of 4
        # To check if number is integer, check if num % 1 == 0
        return (n > 0) and log(n, 4) % 1 == 0
        """
