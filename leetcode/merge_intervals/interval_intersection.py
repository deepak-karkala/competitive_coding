"""
986. Interval List Intersections
Solved
Medium
Topics
Companies
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
"""


class IntervalIntersection:
    def intervalIntersection(
        self, firstList: List[List[int]], secondList: List[List[int]]
    ) -> List[List[int]]:
        res = []
        i, j = 0, 0

        while i < len(firstList) and j < len(secondList):
            # No intersections: First before second
            if firstList[i][1] < secondList[j][0]:
                i += 1
            # No intersections: Second before first
            elif secondList[j][1] < firstList[i][0]:
                j += 1
            # End of second b/w start and end of first
            elif secondList[j][1] <= firstList[i][1]:
                intersect = [
                    max(firstList[i][0], secondList[j][0]),
                    min(firstList[i][1], secondList[j][1]),
                ]
                res.append(intersect)
                j += 1
            else:
                intersect = [
                    max(firstList[i][0], secondList[j][0]),
                    min(firstList[i][1], secondList[j][1]),
                ]
                res.append(intersect)
                i += 1

        return res
