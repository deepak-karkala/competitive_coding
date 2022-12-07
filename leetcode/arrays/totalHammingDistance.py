# Given an array A of N non-negative integers,
# find the sum of hamming distances of all pairs
# of integers in the array. Return the answer modulo 1000000007.

class Solution:
	# @param A : integer array
	# @return an integer
	def hammingDistance(self, A):
		count = 0
		m = 1000000007

		for i in range(32):
			numOnes = 0
			for n in A:
				numOnes+= (n >> i) & 1;
			count += numOnes*(len(A) - numOnes)
		
		return count % m

if __name__ == "__main__":
	sol = Solution()
	ind = sol.hammingDistance([2, 6, 4])
	print(ind)