# Given a column title A as appears in an Excel sheet,
# return its corresponding column number.

class Solution:
	# @param A : string
	# @return an integer
	def titleToNumber(self, A):
		count = 0
		for c in A:
			count *= 26
			count += ord(c) - ord('A') + 1
		#for i in range(len(A)):
		#	count += (ord(A[i]) - ord('A') + 1)  * (26 ** (len(A)-i-1));
		return count

if __name__ == "__main__":
	sol = Solution()
	ind = sol.titleToNumber("ZY")
	print(ind)