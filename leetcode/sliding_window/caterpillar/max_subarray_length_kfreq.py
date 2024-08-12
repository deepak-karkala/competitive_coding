"""
2958. Length of Longest Subarray With at Most K Frequency
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array
"""


class maxSubarrayLengthKFrequency:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        hmap = defaultdict(int)
        left = 0
        maxLen = 0

        for right in range(len(nums)):
            hmap[nums[right]] += 1
            while hmap[nums[right]] > k:
                hmap[nums[left]] -= 1
                left += 1

            maxLen = max(maxLen, right - left + 1)

        return maxLen
