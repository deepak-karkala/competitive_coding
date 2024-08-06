"""
15. 3Sum
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
"""


class ThreeSum:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
        Two Sum: Time:O(n) Space:O(n)
            If numbers are asked and not indices,
                then can be sorted and two pointers can be used
                => Time: O(nlogn) Space: O(1)
        Three Sum:
            Hold one number constant,
            Remaining target-number, becomes two sum problem
        """
        nums.sort()
        res = []

        for i in range(len(nums)):
            # Skip +ve since array is sorted
            if nums[i] > 0:
                break

            left, right = i + 1, len(nums) - 1

            # nums[i] is fixed, rest becomes sorted two sum problem
            #   => Can use two pointers
            while left < right:
                threeSum = nums[i] + nums[left] + nums[right]

                if threeSum > 0:
                    right -= 1
                elif threeSum < 0:
                    left += 1
                else:
                    res.append((nums[i], nums[left], nums[right]))
                    left += 1
                    right -= 1

        res = [list(triplet) for triplet in list(set(res))]
        return res
