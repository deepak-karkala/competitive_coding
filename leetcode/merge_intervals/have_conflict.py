"""
2446. Determine if Two Events Have Conflict
Solved
Easy
Topics
Companies
Hint
You are given two arrays of strings that represent two inclusive events that happened on the same day, event1 and event2, where:

event1 = [startTime1, endTime1] and
event2 = [startTime2, endTime2].
Event times are valid 24 hours format in the form of HH:MM.

A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).

Return true if there is a conflict between two events. Otherwise, return false.
"""


class HaveConflict:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        """
        events = []
        events.append(event1)
        events.append(event2)
        events.sort(key = lambda x: x[0])

        return events[1][0] <= events[0][1]
        """
        return not (event1[0] > event2[1] or event2[0] > event1[1])
