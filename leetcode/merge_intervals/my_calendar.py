"""
729. My Calendar I
Solved
Medium
Topics
Companies
Hint
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
"""

from sortedcontainers import SortedList


"""
class Node:
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.left = None
        self.right = None
    
    def insert(self, start, end):
        # If new event ends before start of this event
        #   => can be added to left of this event
        if self.start >= end:
            if not self.left:
                self.left = Node(start, end)
                return True
            else:
                return self.left.insert(start, end)
        # If new events starts after end of this event,
        #   => can be added to right of this event
        elif self.end <= start:
            if not self.right:
                self.right = Node(start, end)
                return True
            else:
                return self.right.insert(start, end)
        # Overlap with this event, return false
        else:
            return False
"""


class MyCalendar:
    """
    1. Events can come in any order (un-sorted)
    2. Store the events in list and sort it. (BST)
    3. For each event,
        Use binary search to find the index to be inserted,
        If this event does not conflict with prev and next events, return True
    4. Add this event to sorted list

    Two ways to solve
    a. Either use sortedList or
    b. Code a custom BST insert
    """

    def __init__(self):
        self.events = SortedList(
            [(float("-inf"), float("-inf")), (float("inf"), float("inf"))]
        )

    def book(self, start: int, end: int) -> bool:
        idx = self.events.bisect_left((start, end))
        # Check if current event can be inserted without overlap with before and after events
        if start < self.events[idx - 1][1] or end > self.events[idx][0]:
            return False
        self.events.add((start, end))
        return True

    """
    def __init__(self):
        self.root = None

    def book(self, start: int, end: int) -> bool:
        if not self.root:
            self.root = Node(start, end)
            return True
        else:
            return self.root.insert(start, end)
    """


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)
