"""
1004. Max Consecutive Ones III
Solved
Medium
Topics
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
"""


class MaxConsecutiveOnesIII:
    def longestOnes(self, nums: List[int], k: int) -> int:
        """
        Sliding window - Caterpillar
        Whenever I see 0, remove num from left until numZerosFlipped becomes equal to k
        """
        maxOnes = 0
        left = 0
        numZerosFlipped = 0

        for right in range(len(nums)):
            if nums[right] == 0:
                numZerosFlipped += 1

            while numZerosFlipped > k:
                if nums[left] == 0:
                    numZerosFlipped -= 1
                left += 1

            maxOnes = max(maxOnes, right - left + 1)

        return maxOnes
