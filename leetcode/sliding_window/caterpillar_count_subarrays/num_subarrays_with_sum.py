"""
930. Binary Subarrays With Sum
Solved
Medium
Topics
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.
"""


class NumSubarraysWithSum:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        """
        Since all entries are +ve (1 or 0)
        Standard 2 pointers (sw with caterpillar) can be used
        exactly(goal) = atmost(goal) - atmost(goal - 1)
        """

        def atMost(nums, k):
            """
            Num of subarrays with at most sum of k
            """
            left = 0
            currSum = 0
            count = 0

            for right in range(len(nums)):
                currSum += nums[right]

                while left <= right and currSum > k:
                    currSum -= nums[left]
                    left += 1
                count += right - left + 1
            return count

        return atMost(nums, goal) - atMost(nums, goal - 1)
