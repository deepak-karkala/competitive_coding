"""
442. Find All Duplicates in an Array
Solved
Medium
Topics
Companies
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
"""


class FindDuplicates:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []

        for n in nums:
            num = abs(n)

            if nums[num - 1] < 0:
                res.append(num)
            nums[num - 1] *= -1

        return res
