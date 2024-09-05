"""
2402. Meeting Rooms III
Solved
Hard
Topics
Companies
Hint
You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

Each meeting will take place in the unused room with the lowest number.
If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
When a room becomes unused, meetings that have an earlier original start time should be given the room.
Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.
"""


class MeetingRoomsIII:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        num_meetings = [0] * n

        # Start with all rooms as unused
        #   One with lowest id will be at top of heap
        available = [i for i in range(n)]
        # heapq.heapify(unused)

        # Sort the meetings by start time
        meetings.sort()

        # Used: will contain tuple of (end_time, room_id)
        #   If no unused rooms, then pick the used room with earliest end time
        used = []
        # heapq.heapify(used)

        for start, end in meetings:
            # For start time of current meeting,
            #   check end times of all used rooms and then pop those rooms
            #       in which current meeting can be held (curr_start >= room_end)
            while used and start >= used[0][0]:
                end_time, room_id = heapq.heappop(used)
                # Push this room to available
                heapq.heappush(available, room_id)
            # Now all the eligible rooms (end_time <= curr_start) are in available

            # But if there are no such rooms, then use the room with the
            #   earliest end time (top of used minheap) and assign this room to current meeting
            if not available:
                prev_end_time, room_id = heapq.heappop(used)
                end = prev_end_time + (end - start)
                heapq.heappush(available, room_id)

            # If there are available rooms, use the one with lowest room_id
            room_id = heapq.heappop(available)
            num_meetings[room_id] += 1
            # Push this room to used heap
            heapq.heappush(used, (end, room_id))

        return num_meetings.index(max(num_meetings))
