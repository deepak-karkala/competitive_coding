"""
18. 4Sum
Solved
Medium
Topics
Companies
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
"""


class FourSum:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        def kSum(nums, target, start, end, k, subset, subsets):
            if k != 2:
                # Reduce to k-1 sum
                for i in range(start, end + 1):
                    # Skip any duplicate entries if any
                    #   Will be consecutive since array is sorted
                    if i == start or (i > start and nums[i] != nums[i - 1]):
                        kSum(
                            nums,
                            target - nums[i],
                            i + 1,
                            end,
                            k - 1,
                            subset + [nums[i]],
                            subsets,
                        )

            else:
                # Base case k = 2 (Sorted two sum (two pointers))
                l, r = start, end
                while l < r:
                    if nums[l] + nums[r] > target:
                        r -= 1
                    elif nums[l] + nums[r] < target:
                        l += 1
                    else:
                        # Found 1 quadruple
                        subsets.append(subset + [nums[l], nums[r]])
                        # Look for other pairs
                        l += 1
                        # skipping duplicate entries if any
                        #   Will be consecutive since array is sorted
                        while l < r and nums[l] == nums[l - 1]:
                            l += 1

        nums.sort()
        subsets, subset = [], []
        kSum(nums, target, 0, len(nums) - 1, 4, subset, subsets)
        return subsets
