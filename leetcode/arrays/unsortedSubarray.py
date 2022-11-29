class Solution:
	# @param A : list of integers
	# @return a list of integers
    def subUnsort(self, A):
        N = len(A)
        start = -1
        end = -1
        maximum = A[0]
        minimum = A[N-1]
        
        for i in range(1, N):
            if (A[i] >= maximum):
                maximum = A[i]
            else:
                start = i
            
            if (A[N-1-i] <= minimum):
                minimum = A[N-1-i]
            else:
                end = N-1-i

        #print(start, end)
        if (start > end):
            return [i for i in [end, start]]
        else:
            return [-1]            
            

if __name__ == "__main__":
    sol = Solution()
    ind = sol.subUnsort([2,6,4,8,10,9,15])
    #ind = sol.subUnsort([1, 2, 3])
    print(ind)
