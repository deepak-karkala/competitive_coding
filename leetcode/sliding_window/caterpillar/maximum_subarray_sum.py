"""
2461. Maximum Sum of Distinct Subarrays With Length K
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.
"""


class MaximumSubarraySum:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        hset = set()
        left = 0
        winSum, maxSum = 0, 0

        for right in range(len(nums)):
            while nums[right] in hset:
                winSum -= nums[left]
                hset.remove(nums[left])
                left += 1

            winSum += nums[right]
            hset.add(nums[right])

            if right - left + 1 == k:
                maxSum = max(maxSum, winSum)
                winSum -= nums[left]
                hset.remove(nums[left])
                left += 1

        return maxSum
