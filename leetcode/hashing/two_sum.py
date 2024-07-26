"""
1. Two Sum
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
"""


class TwoSum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for idx, n in enumerate(nums):
            if target - n in map:
                return [idx, map[target - n]]
            map[n] = idx
