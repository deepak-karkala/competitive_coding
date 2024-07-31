"""
238. Product of Array Except Self
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
"""


class ProductExceptSelf:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prodLeft = [1 for i in range(len(nums) + 2)]
        prodRight = [1 for i in range(len(nums) + 2)]
        i, j = 0, len(nums) - 1

        while i < len(nums):
            prodLeft[i + 1] = prodLeft[i] * nums[i]
            prodRight[j + 1] = prodRight[j + 2] * nums[j]
            i += 1
            j -= 1

        res = []
        for i in range(len(nums)):
            res.append(prodLeft[i] * prodRight[i + 2])
        return res

    def productExceptSelf2(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)

        curr = 1
        for i in range(len(nums)):
            res[i] *= curr
            curr *= nums[i]

        curr = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= curr
            curr *= nums[i]

        return res
