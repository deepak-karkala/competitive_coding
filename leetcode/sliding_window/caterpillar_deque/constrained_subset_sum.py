"""
1425. Constrained Subsequence Sum
Solved
Hard
Topics
Companies
Hint
Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.
"""


class ConstrainedSubsetSum:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        """
        DP(in place) + deque
        """
        res = float(-inf)
        queue = collections.deque()

        for right in range(len(nums)):
            # DP (ending at i, max sum)
            # queue[0] has the max(dp[i-k], dp[i-k+1]...dp[i-1])
            nums[right] += queue[0] if queue else 0
            res = max(res, nums[right])

            while queue and queue[-1] < nums[right]:
                queue.pop()

            if nums[right] > 0:
                queue.append(nums[right])

            if right >= k and queue and queue[0] == nums[right - k]:
                queue.popleft()

        return res
