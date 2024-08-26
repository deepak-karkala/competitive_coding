"""
57. Insert Interval
Solved
Medium
Topics
Companies
Hint
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.
"""


class InsertInterval:
    def insert(
        self, intervals: List[List[int]], newInterval: List[int]
    ) -> List[List[int]]:
        res = []
        for i in range(len(intervals)):
            # New interval's end is before current interval's start
            # Insert new interval first and then append rest of intervals and return
            if newInterval[1] < intervals[i][0]:
                res.append(newInterval)
                return res + intervals[i:]
            # New interval's start is after current interval's end
            # Insert current interval,
            # new interval could be merged with next interval, so don't append to result yet
            elif newInterval[0] > intervals[i][1]:
                res.append(intervals[i])
            # New interval overlaps with current interval
            # Merge the two intervals and don't append to result yet because it could
            #   still be merged with next interval
            else:
                newInterval = [
                    min(intervals[i][0], newInterval[0]),
                    max(intervals[i][1], newInterval[1]),
                ]

        res.append(newInterval)
        return res
