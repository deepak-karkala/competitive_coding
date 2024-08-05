"""
779. K-th Symbol in Grammar
Solved
Medium
Topics
Companies
Hint
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
"""


class KthGrammar:
	"""
    0 -> 01 -> 0110 -> ...
    Two observations from this,
        1. digit(n, k) = digit(n - 1, (k + 1)//2)
            At each level, we should figure out whether to go to left/right subtree
            => Compare mid to k
        2. At every level, even bit is flipped compared to prev level
            if k is even, flip the digit
            else return digit as is
    """

    # Iterative
    def kthGrammar(self, n: int, k: int) -> int:
        
        digit = 0  # 1st row
        left, right = 0, 2 ** (n - 1)

        for _ in range(n - 1):  # Iterate over next n-1 rows
            mid = (left + right) // 2
            if k <= mid:
                right = mid
            else:
                left = mid + 1
                digit = 0 if digit else 1
        return digit

    # Recursive
    def kthGrammar2(self, n: int, k: int) -> int:
        if n == 1:
            return 0

        digit = self.kthGrammar(n - 1, (k + 1) // 2)
        if k % 2 == 0:
            return 0 if digit else 1
        else:
            return digit
