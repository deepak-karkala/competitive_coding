"""
525. Contiguous Array
Solved
Medium
Topics
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
"""

class FindMaxLength:
    def findMaxLength(self, nums: List[int]) -> int:
        maxLen = 0
        map = {}
        numZeroes, numOnes = 0, 0

        for i, n in enumerate(nums):
            if n == 0:
                numZeroes += 1
            else:
                numOnes += 1
            
            diff = numOnes - numZeroes
            if diff not in map:
                map[diff] = i
            
            if diff == 0:
                maxLen = numOnes + numZeroes
            else:
                maxLen = max(maxLen, i - map[diff])
        
        return maxLen
