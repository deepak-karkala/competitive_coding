"""
1578. Minimum Time to Make Rope Colorful
Solved
Medium
Topics
Companies
Hint
Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.
"""


class RopeColorful:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        """
        Whenever we encounter two adjacent balloons with same color,
            remove the balloon with the least neededTime
        Two pointers to track the indices of balloons
        """
        # Left and right pointers at first two balloons
        left, right = 0, 1
        numTime = 0

        while right < len(colors):
            # IF adjacent balloons are same color
            if colors[left] == colors[right]:
                # Check which of the two with same colors has least neededTime
                if neededTime[left] <= neededTime[right]:
                    numTime += neededTime[left]
                    left = right
                else:
                    numTime += neededTime[right]
            else:
                left = right
            right += 1

        return numTime
