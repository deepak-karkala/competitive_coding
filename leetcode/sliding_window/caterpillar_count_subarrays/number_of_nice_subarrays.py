"""
1248. Count Number of Nice Subarrays
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
"""


class numberOfNiceSubarrays:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        """
        2 ways to solve
        1. Exactly(k odd) = Atmost(k odd) - Atmost(k-1 odd)
            a. Atmost(k) can be solved using standard sw caterpillar
            b. (counting num of subarrays ending at right pointer = right - left + 1 (len of subarray))
        2. Replace even with 0 and odd with 1
            => Num of nice subarrays = num of subarrays with sum k
        """

        def getAtMostK(nums: List[int], k: int) -> int:
            numOdd = 0
            left = 0
            numAtMostk = 0

            for right in range(len(nums)):
                if nums[right] % 2 == 1:
                    numOdd += 1

                while numOdd > k:
                    if nums[left] % 2 == 1:
                        numOdd -= 1
                    left += 1

                # Count num of subarrays ending at right pointer
                #   = len of subarray (right - left + 1)
                numAtMostk += right - left + 1

            return numAtMostk

        return getAtMostK(nums, k) - getAtMostK(nums, k - 1)
