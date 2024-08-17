"""
1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
"""

class LongestSubarrayDiffLimit:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        left = 0
        maxQueue = collections.deque()
        minQueue = collections.deque()
        maxLen = 0

        for right in range(len(nums)):
            # Pop all num < currNum in maxQueue
            while maxQueue and nums[maxQueue[-1]] < nums[right]:
                maxQueue.pop()
            # Pop all num > currNum in minQueue
            while minQueue and nums[minQueue[-1]] > nums[right]:
                minQueue.pop()
            
            maxQueue.append(right)
            minQueue.append(right)

            # As long as curr window is invalid (max - min > limit)
            #   move the left pointer until it becomes valid
            while (nums[maxQueue[0]] - nums[minQueue[0]]) > limit:
                if nums[left] == nums[maxQueue[0]]:
                    maxQueue.popleft()
                if nums[left] == nums[minQueue[0]]:
                    minQueue.popleft()
                left += 1
            
            maxLen = max(maxLen, right - left + 1)
        return maxLen