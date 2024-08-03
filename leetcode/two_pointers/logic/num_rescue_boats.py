"""
881. Boats to Save People
Solved
Medium
Topics
Companies
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.
"""


class NumRescueBoats:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        """
        Sort by weight
            Intuition: Try to pair lightest and heaviest together
        1. If they can go together, in a boat update both left and right pointers
        2. If not, update only the right pointer (=> assigning heavier person a separate boat)
        3. Try to pair the next light person with the next less heavier person
        """
        people.sort()
        left, right = 0, len(people) - 1
        numBoats = 0

        while left <= right:
            if people[left] + people[right] <= limit:
                left += 1
            right -= 1
            numBoats += 1
        return numBoats
