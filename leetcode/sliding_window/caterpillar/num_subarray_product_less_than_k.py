"""
713. Subarray Product Less Than K
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
"""


class NumSubarrayProductLessThanK:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        numSub = 0
        winProd = 1
        left = 0

        for right in range(len(nums)):
            winProd *= nums[right]

            while left <= right and winProd >= k:
                winProd = winProd // nums[left]
                left += 1

            # Intuition 1:
            #   Num of subarrays satisfying given condition = len of subarray (r - l + 1)
            # Intuition 2:
            #   This is the num of subarrays ending at right pointer
            numSub += right - left + 1

        return numSub
