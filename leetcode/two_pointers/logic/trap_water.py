"""
42. Trapping Rain Water
Solved
Hard
Topics
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
"""


class TrapWater:
    def trap(self, height: List[int]) -> int:
        maxLeft, maxRight = 0, 0
        left, right = 0, len(height) - 1
        trapWater = 0

        while left < right:
            # Start accumulating from left since left is shorter than right
            if height[left] <= height[right]:
                # Check if curr bar is tallest from left,
                #   If so, update the maxLeft
                #   If not, accumulate water for this bar
                if height[left] > maxLeft:
                    maxLeft = height[left]
                else:
                    trapWater += maxLeft - height[left]
                left += 1
            # Start accumulating from right since left is taller than right
            else:
                if height[right] > maxRight:
                    maxRight = height[right]
                else:
                    trapWater += maxRight - height[right]
                right -= 1

        return trapWater
