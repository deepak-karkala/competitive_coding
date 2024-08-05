"""
283. Move Zeroes
Solved
Easy
Topics
Companies
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
"""


class MoveZeroes:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 1:
            return

        # Index to be written at
        writePtr = 0

        # Index to be read at
        for readPtr in range(len(nums)):
            if nums[readPtr] != 0:
                nums[writePtr] = nums[readPtr]
                writePtr += 1

        while writePtr < len(nums):
            nums[writePtr] = 0
            writePtr += 1
