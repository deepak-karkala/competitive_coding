"""
80. Remove Duplicates from Sorted Array II
Solved
Medium
Topics
Companies
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
"""


class RemoveDuplicatesII:
    def removeDuplicates(self, nums: List[int]) -> int:
        readPtr, writePtr = 0, 0

        while readPtr < len(nums):
            countCurrChar = 1

            # Iterate readPtr as long as same digit
            # Update writePtr only when count <= 2
            while readPtr + 1 < len(nums) and nums[readPtr] == nums[readPtr + 1]:
                countCurrChar += 1
                readPtr += 1

            for _ in range(min(2, countCurrChar)):
                nums[writePtr] = nums[readPtr]
                writePtr += 1

            readPtr += 1

        return writePtr
