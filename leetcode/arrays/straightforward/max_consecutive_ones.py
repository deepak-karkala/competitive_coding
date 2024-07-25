"""
485. Max Consecutive Ones
Solved
Easy
Topics
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.
"""


class MaxConsecutiveOnes(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count, maxCount = 0, 0

        for n in nums:
            if n == 0:
                maxCount = max(count, maxCount)
                count = 0
            else:
                count += 1

        return max(maxCount, count)
