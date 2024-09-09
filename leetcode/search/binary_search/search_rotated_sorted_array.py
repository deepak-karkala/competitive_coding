"""
33. Search in Rotated Sorted Array
Solved
Medium
Topics
Companies
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
"""


class SearchRotatedSortedArray:
    def search(self, nums: List[int], target: int) -> int:
        """
        1. When we split at mid, one of the halves will be sorted, two possibilities
            a. nums[left] < nums[mid]
                => LEft half is sorted, check if target lies in this range,
                if yes, move right to mid - 1, if no, move left to mid + 1
            b. nums[left] > nums[mid] => nums[mid] <= nums[right]
                => Right half is sorted, check if target lies in this range,
                if yes, move left to mid + 1, if no, move right to mid - 1
        """
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid

            if nums[left] <= nums[mid]:
                # LEft half is sorted
                if nums[left] <= target and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # Right half is sorted
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1
