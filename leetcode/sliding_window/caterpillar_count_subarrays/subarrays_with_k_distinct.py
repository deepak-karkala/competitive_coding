"""
992. Subarrays with K Different Integers
Solved
Hard
Topics
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.
"""


class SubarraysWithKDistinct:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        """
        Exactly(k integers) = AtMost(k integers) - AtMost(k - 1 integers)
        AtMost(k) can be solved using standard sliding window caterpillar
            Counting num of subarrays ending at right pointer = right - left + 1
        """

        def atMost(nums, k):
            left = 0
            count = 0
            hmap = defaultdict(int)

            for right in range(len(nums)):
                hmap[nums[right]] += 1

                while len(hmap) > k:
                    hmap[nums[left]] -= 1
                    if hmap[nums[left]] == 0:
                        hmap.pop(nums[left])
                    left += 1

                # Counting num of subarrays ending at right pointer = right - left + 1
                count += right - left + 1
            return count

        return atMost(nums, k) - atMost(nums, k - 1)
