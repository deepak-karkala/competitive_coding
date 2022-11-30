class Solution:
	# @param A : integer
	# @return an integer
    def factorialZeroes(self, A):
        count = 0
        while (A > 0):
            A = int(A/5)
            count += A
            return count


if __name__ == "__main__":
    sol = Solution()
    ind = sol.factorialZeroes(12)
    print(ind)