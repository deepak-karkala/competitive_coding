/*
779. K-th Symbol in Grammar
Medium
Topics
Companies
Hint
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in
every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
*/


class KthGrammar {
	/*
	// think of the problem like this
		/*        0
		      /       \
		     0          1
		   /   \      /    \
		   0     1    1      0
		 / \     / \   / \   / \
		 0  1   1   0  1  0  0  1
	Observations:
		1. the parent of kth index in nth row is
			k/2 index in the n-1 row for even numbered indexes.
			(k+1)/2 index in the n-1 row for odd numbered indexes.
		
		2. Also notice that the kth value of the index in nth row is:
			flipped (reversed) value of the parent i.e. k/2 index in the n-1 row for even numbered indexes.
			same value as for the parent i.e. the (k+1)/2 index in the n-1 row for odd numbered indexes.

	*/
    private static int kthGrammar(int n, int k) {
    	// Base case
    	if (n == 1) return 0;

        // Get parent (corresponding bit in n-1th row)
        // Based on observation 1,
        // Nth row k should map to k/2 in N-1th row for both odd and even k
        //		=> (k+1)/2
        int parent = kthGrammar(n-1, (k+1)/2);

        // Based on observation 2,
        // If k is even in nth row, bit is flipped wrt to n-1th row
        // If k is odd in nth row, return same bit as in n-1th row
        if (k % 2 == 0)
        	return parent == 0 ? 1 : 0;
       	else
       		return parent;
    }

    public static void main(String[] args) {
    	int n = 3, k = 1;
    	System.out.println(kthGrammar(n, k));
    }
}