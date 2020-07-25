"""
Given an array of integers, return indices of the two numbers such that
they add up to a specific target.
You may assume that each input would have exactly one solution, and you
may not use the same element twice.
"""
from typing import List


class Solution:
    def two_sum_brute_force(self, nums: List[int], target: int) -> List[int]:
        for i, num1 in enumerate(nums):
            for j in range(i+1, len(nums)):
                num2 = nums[j]
                if (j != i) and (num1 + num2 == target):
                    target_indices = [i, j]
                    return target_indices

    def two_sum_hashmap(self, nums: List[int], target: int) -> List[int]:
        hashmap = dict()
        pos = 0
        while pos < len(nums):
            if (target - nums[pos]) not in hashmap:
                hashmap[nums[pos]] = pos
            else:
                return [hashmap[target - nums[pos]], pos]
            pos += 1
        raise Exception("No two sum solution")


if __name__ == "__main__":
    sol = Solution()
    indices = sol.two_sum_hashmap([2, 7, 11, 15], 9)
    print(indices)