"""
Given an array of integers and an integer k, you need to find
the total number of continuous subarrays whose sum equals to k.
Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
"""

from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        num_subarray_sum = 0
        cumulative_sum = []
        cumulative_sum.append(nums[0])
        for i, num in enumerate(nums[1:]):
            cumulative_sum.append(cumulative_sum[-1] + num)
        nums_len = len(nums)

        i = 0
        while i < nums_len:
            j = i
            while j < nums_len:
                if i == 0:
                    subarray_sum = cumulative_sum[j]
                else:
                    subarray_sum = cumulative_sum[j] - cumulative_sum[i - 1]
                # print(str(i) + "  " + str(j) + "  " + str(subarray_sum))
                if subarray_sum == k:
                    num_subarray_sum += 1
                j += 1
            i += 1
        return num_subarray_sum

    def subarraySum_bruteforce(self, nums: List[int], k: int) -> int:
        num_subarray_sum = 0

        for i in range(len(nums)):
            j = i
            sum = 0
            while j < len(nums):
                sum += nums[j]
                if sum == k:
                    num_subarray_sum += 1
                j += 1

        return num_subarray_sum


if __name__ == "__main__":
    sol = Solution()
    print(sol.subarraySum([1, 1, 1], 2))
