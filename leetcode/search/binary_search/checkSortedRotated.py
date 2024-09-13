"""
1752. Check if Array Is Sorted and Rotated
Easy
Topics
Companies
Hint
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
"""


class checkSortedRotated:
    def check(self, nums: List[int]) -> bool:
        """
        For an array to be sorted, rotated array
            => There can only be atmost one index where nums[i] < nums[i - 1]
        (this should also include first and last index nums[0] > nums[-1] unless 0 is the start of the array)
        """
        return sum(nums[i] < nums[i - 1] for i in range(len(nums))) <= 1
