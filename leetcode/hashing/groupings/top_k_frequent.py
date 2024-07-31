"""
347. Top K Frequent Elements
Solved
Medium
Topics
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
"""


class TopKFrequent:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}  # Map num: Number of occurrences
        # List of List (All numbers occurring 'n' times are grouped together in a list)
        #   Index of list will give number of occurrences
        freq = [[] for i in range(len(nums) + 1)]

        # Result list
        res = []

        for num in nums:
            count[num] = 1 + count.get(num, 0)

        for num, cnt in count.items():
            freq[cnt].append(num)

        # Iterate through freq (in reverse order => Most occurring first)
        for i in range(len(freq) - 1, -1, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res

    def topKFrequent2(self, nums: List[int], k: int) -> List[int]:
        # Counter
        count = Counter(nums)
        # Heap (List of List)
        maxHeap = [[-freq, num] for num, freq in count.items()]
        heapify(maxHeap)

        res = []
        for i in range(k):
            _, num = heappop(maxHeap)
            res.append(num)

        return res
