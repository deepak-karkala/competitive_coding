"""
162. Find Peak Element
Solved
Medium
Topics
Companies
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.
"""


class findPeakElement:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low < high:
            mid1 = low + (high - low) // 2
            mid2 = mid1 + 1

            if nums[mid1] < nums[mid2]:
                low = mid2
            else:
                high = mid1

        return low
