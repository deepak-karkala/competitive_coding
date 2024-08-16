"""
974. Subarray Sums Divisible by K
Solved
Medium
Topics
Companies
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
"""


class SubarraysDivByK:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        hmap = defaultdict(int)
        hmap[0] = 1
        currSum = 0
        numSub = 0

        for i in range(len(nums)):
            currSum = (currSum + nums[i]) % k
            if currSum < 0:
                currSum += k

            numSub += hmap[currSum]
            hmap[currSum] += 1

        return numSub
