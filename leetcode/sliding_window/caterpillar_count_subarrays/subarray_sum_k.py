"""
560. Subarray Sum Equals K
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
"""


class subarraySum:
    def subarraySum(self, nums: List[int], k: int) -> int:
        """
        Anti pattern: sum(exactly k) = sum(atMost k) - sum(atMost k-1) will not work.
            2 pointers/Sliding window with caterpillar does not work
        Solution: Prefix sum hashing
        """
        hmap = defaultdict(int)
        hmap[0] = 1
        accSum, count = 0, 0

        for i in range(len(nums)):
            accSum += nums[i]

            if accSum - k in hmap:
                count += hmap[accSum - k]
            hmap[accSum] += 1
        return count
