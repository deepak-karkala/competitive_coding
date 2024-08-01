"""
1498. Number of Subsequences That Satisfy the Given Sum Condition
Medium
Topics
Companies
Hint
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.
"""


class NumSubseq:
    def numSubseq(self, nums: List[int], target: int) -> int:
        """
        Sort,
        start with two pointers from both ends,
            if sum of first and last element exceeds target, decrement right by 1,
            else it means subsequence with this left and right pointers meet the criteria
                so count the number of subsequences (for left and right pointers at l and r,
                number of subsequences = 1 << (r - l)
        """
        nums.sort()
        l, r = 0, len(nums) - 1
        numSubSeq, mod = 0, (10**9 + 7)

        while l <= r:
            if nums[l] + nums[r] > target:
                r -= 1
            else:
                numSubSeq += 1 << (r - l)
                l += 1

        return numSubSeq % mod
