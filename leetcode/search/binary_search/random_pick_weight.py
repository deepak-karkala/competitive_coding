"""
528. Random Pick with Weight
Solved
Medium
Topics
Companies
You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
"""


class RandomPickWeight:
    def __init__(self, w: List[int]):
        acc_sum = 0
        self.w = w
        for i in range(len(w)):
            acc_sum += w[i]
            self.w[i] = acc_sum

    def pickIndex(self) -> int:
        target = random.randint(1, self.w[-1])
        # Find the index (first number greater than target)

        left, right = 0, len(self.w)

        while left < right:
            mid = left + (right - left) // 2
            if target > self.w[mid]:
                left = mid + 1
            else:
                right = mid

        return left


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
