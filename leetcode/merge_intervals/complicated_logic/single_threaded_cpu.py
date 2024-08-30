"""
1834. Single-Threaded CPU
Medium
Topics
Companies
Hint
You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:

If the CPU is idle and there are no available tasks to process, the CPU remains idle.
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
Once a task is started, the CPU will process the entire task without stopping.
The CPU can finish a task then start a new one instantly.
Return the order in which the CPU will process the tasks.
"""


class SingleThreadedCPU:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        """
        1. Sort tasks by enqueue time
        2. At each time step, I can process all the tasks with enqueue time >= curr_time
            i. I need to process this in order of processing time
            ii. => I will store all such tasks in a minHeap
            iii. I will also need to store index to break ties in processing time
        3. Go on appending idx to result
        4. If heap is empty
            => No task can be added at curr_time
            Jump time to next task with min enqueue time (next idx in sorted tasks)
        """
        # Overwrite tasks with sorted tasks (also add index needed to break ties
        #   in heap and also for final result, since sort will lose this information)
        tasks = sorted([(t[0], t[1], i) for i, t in enumerate(tasks)])
        heap, order = [], []
        curr_time = tasks[0][0]
        curr_task_index = 0

        while len(order) < len(tasks):
            # Add all tasks which have enqueue time >= curr_time
            while (
                curr_task_index < len(tasks) and tasks[curr_task_index][0] <= curr_time
            ):
                heapq.heappush(
                    heap, (tasks[curr_task_index][1], tasks[curr_task_index][2])
                )
                curr_task_index += 1

            # Pick the task with least processing time (heap top)
            if heap:
                processing_time, idx = heapq.heappop(heap)
                order.append(idx)
                curr_time += processing_time
            elif curr_task_index < len(tasks):
                # No tasks in heap, => Move curr_time to enqueue time for next task
                curr_time = tasks[curr_task_index][0]

        return order
