"""
452. Minimum Number of Arrows to Burst Balloons
Solved
Medium
Topics
Companies
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
"""


class FindMinArrowShots:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # Sort by start and end
        points.sort()

        num_arrows = len(points)
        prev = points[0]

        for curr in points[1:]:
            # If current balloon overlaps with prev, one less arrow is needed
            if curr[0] <= prev[1]:
                num_arrows -= 1
                prev = [curr[0], min(prev[1], curr[1])]
            else:
                prev = curr

        return num_arrows
