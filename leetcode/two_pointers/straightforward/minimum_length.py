"""
1750. Minimum Length of String After Deleting Similar Ends
Solved
Medium
Topics
Companies
Hint
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).
"""


class MinimumLength:
    def minimumLength(self, s: str) -> int:
        left, right = 0, len(s) - 1

        while left < right:
            if s[left] != s[right]:
                break
            else:
                prefixChar = s[left]
                while left < len(s) and s[left] == prefixChar:
                    left += 1
                while right >= 0 and s[right] == prefixChar:
                    right -= 1

        return max(0, right - left + 1)
