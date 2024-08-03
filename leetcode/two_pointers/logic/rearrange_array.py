"""
1968. Array With Elements Not Equal to Average of Neighbors
Solved
Medium
Topics
Companies
Hint
You are given a 0-indexed array nums of distinct integers. You want to rearrange the elements in the array such that every element in the rearranged array is not equal to the average of its neighbors.

More formally, the rearranged array should have the property such that for every i in the range 1 <= i < nums.length - 1, (nums[i-1] + nums[i+1]) / 2 is not equal to nums[i].

Return any rearrangement of nums that meets the requirements.
"""


class RearrangeArray:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        """
        Given a sorted array, how to rearrange numbers in low-high-low-high-… order.
        Take the first half of sorted array and insert them in [0::2] (even indices),
                second half of sorted array and insert them in [1::2] (odd indices).
        => Every number at odd index will be higher than its neighbours and
                every number at even index will be lower than its neighbours.
        => each number never equal to average of its neighbours
        """
        nums.sort()
        mid = math.ceil(len(nums) / 2)
        nums[0::2], nums[1::2] = nums[0:mid], nums[mid:]
        return nums
