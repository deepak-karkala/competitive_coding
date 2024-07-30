"""
665. Non-decreasing Array
Solved
Medium
Topics
Companies
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
"""


class NonDecreasingArray:
    def checkPossibility(self, nums: List[int]) -> bool:
        changed = False

        for i in range(len(nums) - 1):
            if nums[i + 1] >= nums[i]:  # Increasing, do nothing
                continue

            if changed:  # If not increasing and already changed, return False
                return False

            # If decreasing (nums[i] < nums[i+1]), there are two options
            ### Decrement nums[i] = nums[i + 1] or
            ### Increment nums[i + 1] = nums[i]
            # Which of these options to choose will depend on,
            ### the highest element obtained till now,
            ### which will be in nums[i - 1]
            # => That's why Compare nums[i + 1] and nums[i - 1]
            ### to determine which of the two options to choose
            if i == 0 or nums[i + 1] >= nums[i - 1]:
                nums[i] = nums[i + 1]
            else:
                nums[i + 1] = nums[i]
            changed = True

        return True
