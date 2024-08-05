"""
26. Remove Duplicates from Sorted Array
Solved
Easy
Topics
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
"""

class RemoveDuplicates:
    def removeDuplicates(self, nums: List[int]) -> int:
        readPtr, writePtr = 1, 0

        while readPtr < len(nums):
            if nums[readPtr] != nums[readPtr - 1]:
                nums[writePtr + 1] = nums[readPtr]
                writePtr += 1
            readPtr += 1

        return writePtr + 1
