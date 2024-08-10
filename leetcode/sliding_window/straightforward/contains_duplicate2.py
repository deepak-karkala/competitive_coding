"""
219. Contains Duplicate II
Solved
Easy
Topics
Companies
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
"""


class ContainsNearbyDuplicate:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        """
        hmap = {}
        for i in range(len(nums)):
            if nums[i] in hmap:
                if (i - hmap[nums[i]]) <= k:
                    return True
            hmap[nums[i]] = i
        return False
        """

        hset = set()
        left = 0

        for right in range(len(nums)):
            if right - left > k:
                hset.remove(nums[left])
                left += 1

            if nums[right] in hset:
                return True

            hset.add(nums[right])

        return False
