"""
209. Minimum Size Subarray Sum
Solved
Medium
Topics
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
"""


class MinSubArrayLen:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        minLen, winSum = inf, 0
        left = 0

        for right in range(len(nums)):
            winSum += nums[right]

            while winSum >= target:
                minLen = min(minLen, right - left + 1)
                winSum -= nums[left]
                left += 1

        return 0 if minLen == inf else minLen
