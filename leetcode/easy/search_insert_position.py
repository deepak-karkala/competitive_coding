"""
Given a sorted array and a target value, return the index if the
target is found. If not, return the index where it would be if it
were inserted in order.
You may assume no duplicates in the array.
"""

from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        i = 0
        while i < len(nums):
            if target <= nums[i]:
                return i
            i += 1
        return i

    def searchInsert_slow(self, nums: List[int], target: int) -> int:
        if target < nums[0]:
            return 0
        if target > nums[len(nums)-1]:
            return len(nums)
        for i, num in enumerate(nums):
            if num == target:
                return i
            if (i == len(nums)-1) or (nums[i] < target < nums[i + 1]):
                return i+1


if __name__ == "__main__":
    sol = Solution()
    print(sol.searchInsert([1,3,5,6], 7))
