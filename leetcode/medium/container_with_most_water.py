"""
Given n non-negative integers a1, a2, ..., an , where each represents
a point at coordinate (i, ai). n vertical lines are drawn such that
the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
which together with x-axis forms a container, such that the container
contains the most water.
"""
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        i = 0
        j = len(height) - 1
        max_area = (j-i) * min(height[i], height[j])

        while j > i:
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
            current_area = (j-i) * min(height[i], height[j])
            if current_area > max_area:
                max_area = current_area

        return max_area

    def maxArea_bruteforce(self, height: List[int]) -> int:
        i = 0
        current_max_height = 0
        max_area = 0
        lines_with_max_area = []
        while i < len(height):
            h1 = height[i]
            if h1 > current_max_height:
                current_max_height = h1
                j = i+1
                while j < len(height):
                    h2 = height[j]
                    current_area = (j-i) * min(h1, h2)
                    if current_area > max_area:
                        max_area = current_area
                        lines_with_max_area = [i, j]
                    j += 1
            i += 1
        return max_area


if __name__ == "__main__":
    sol = Solution()
    print(sol.maxArea([1,8,6,2,5,4,8,3,7]))