"""
905. Sort Array By Parity
Solved
Easy
Topics
Companies
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
"""


class SortArrayByParity:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        left, right = 0, 1

        while right < len(nums):
            # Left is odd
            if nums[left] % 2 != 0:
                # Right is even
                if nums[right] % 2 == 0:
                    nums[left], nums[right] = nums[right], nums[left]
                    left += 1
                right += 1
            else:
                left += 1
                right += 1

        return nums
