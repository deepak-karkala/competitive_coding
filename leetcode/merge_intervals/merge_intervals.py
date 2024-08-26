"""
56. Merge Intervals
Solved
Medium
Topics
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
"""


class MergeIntervals:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        non_overlap = []
        intervals.sort(key=lambda x: x[0])
        non_overlap.append(intervals[0])

        for interval in intervals[1:]:
            curr_start, curr_end = interval[0], interval[1]
            prev_start, prev_end = non_overlap[-1][0], non_overlap[-1][1]

            if curr_start > prev_end:
                # Non overlapping case, append the new interval
                non_overlap.append(interval)
            else:
                # Merge intervals (end should max of prev_end and curr_end)
                non_overlap[-1][1] = max(prev_end, curr_end)

        return non_overlap
