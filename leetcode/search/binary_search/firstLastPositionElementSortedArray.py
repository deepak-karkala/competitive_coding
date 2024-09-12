"""
34. Find First and Last Position of Element in Sorted Array
Solved
Medium
Topics
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity
"""


class FirstLastPositionElementSortedArray:
    def leftSearch(self, nums, target):
        low, high = 0, len(nums) - 1
        idx = -1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                idx = mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return idx

    def rightSearch(self, nums, target):
        low, high = 0, len(nums) - 1
        idx = -1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                idx = mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return idx

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.leftSearch(nums, target), self.rightSearch(nums, target)]
