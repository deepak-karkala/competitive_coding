"""
Determine whether an integer is a palindrome.
An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
Therefore it is not a palindrome.
"""


class Solution:
    def is_palindrome(self, x: int) -> bool:

        if (x < 0) or ((x % 10 == 0) and (x != 0)):
            return False

        reverted_number = 0
        while x > reverted_number:
            reverted_number = reverted_number * 10 + x % 10
            x = int(x / 10)

        return (x == reverted_number) or (x == int(reverted_number/10))


if __name__ == "__main__":
    sol = Solution()
    print(sol.is_palindrome(12341))


