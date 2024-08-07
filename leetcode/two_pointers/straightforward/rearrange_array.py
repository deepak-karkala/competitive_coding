"""
2149. Rearrange Array Elements by Sign
Solved
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
"""


class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        posList = []
        negList = []
        for num in nums:
            if num > 0:
                posList.append(num)
            else:
                negList.append(num)

        res = [0] * len(nums)
        for i in range(len(nums)):
            if i % 2 == 0:
                res[i] = posList[i // 2]
            else:
                res[i] = negList[i // 2]

        return res

    def rearrangeArray2(self, nums: List[int]) -> List[int]:
        evenIdx, oddIdx = 0, 1
        res = [0] * len(nums)
        for i in range(len(nums)):
            if nums[i] > 0:
                res[evenIdx] = nums[i]
                evenIdx += 2
            else:
                res[oddIdx] = nums[i]
                oddIdx += 2

        return res
