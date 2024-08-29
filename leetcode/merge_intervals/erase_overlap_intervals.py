"""
435. Non-overlapping Intervals
Solved
Medium
Topics
Companies
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
"""


class EraseOverlapIntervals:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        num_removal = 0
        # Sort by start and then by end times
        intervals.sort(key=lambda x: (x[0], x[1]))
        prev_end = intervals[0][1]

        for curr_start, curr_end in intervals[1:]:
            if curr_start < prev_end:
                num_removal += 1
                prev_end = min(prev_end, curr_end)
            else:
                prev_end = curr_end

        return num_removal
