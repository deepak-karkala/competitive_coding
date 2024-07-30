"""
523. Continuous Subarray Sum
Medium
Topics
Companies
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
"""


class CheckSubarraySum:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        """Logic
        - Keep track of remainder(cumulative_sum % k) that we get at each index
        - Anytime we have the same remainder occuring twice =>
             the gap between the two indices will form a good subarray. Return true
        """
        # Map: remainder -> index
        map = {}
        map[0] = -1
        sum = 0

        for i, num in enumerate(nums):
            sum += num

            if sum % k in map:
                if i - map[sum % k] >= 2:  # Check if min length of 2
                    return True
                else:
                    continue
            map[sum % k] = i

        return False
