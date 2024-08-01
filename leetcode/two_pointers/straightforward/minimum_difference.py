"""
1984. Minimum Difference Between Highest and Lowest of K Scores
Solved
Easy
Topics
Companies
Hint
You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.

Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.

Return the minimum possible difference.
"""


class MinimumDifference:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        if k == 1 or len(nums) == 1:
            return 0

        nums.sort()
        minDiff = float("inf")
        for i in range(0, len(nums) - k + 1):
            minDiff = min(minDiff, nums[i + k - 1] - nums[i])
        return minDiff
