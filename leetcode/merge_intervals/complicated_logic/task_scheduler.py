"""
621. Task Scheduler
Solved
Medium
Topics
Companies
Hint
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
Each cycle or interval allows the completion of one task. Tasks can be completed in any order,
but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

Return the minimum number of intervals required to complete all tasks.
"""


class TaskScheduler:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        min_time = 0

        count = Counter(tasks)
        # Task with highest frequency at the top of heap
        #   We only need how many tasks of each type are remaining,
        #       not how many of which tasks.
        maxHeap = [-cnt for cnt in count.values()]
        heapq.heapify(maxHeap)

        time = 0
        # Queue will store tasks which are waiting till idle time
        #   Once they are ready to be processed, will be inserted back to heap
        # queue will contain list of [-cnt, idle_time]
        queue = collections.deque()

        while maxHeap or queue:
            time += 1

            # Decrement count of this task
            if maxHeap:
                cnt = heapq.heappop(maxHeap) + 1
                if cnt:
                    queue.append([cnt, time + n])

            # If current time = time of first task in queue, then
            #   add that task back to maxHeap
            if queue and queue[0][1] == time:
                heapq.heappush(maxHeap, queue.popleft()[0])

        return time
