/*
498. Diagonal Traverse
Medium
Topics
Companies
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
*/

class FindDiagonalOrder {
    private static int[] findDiagonalOrder(int[][] mat) {
    	int numRows = mat.length, numCols = mat[0].length;
        int[] arr = new int[numRows * numCols];

        int r = 0, c = 0;
        for(int i=0; i<arr.length; i++) {
        	arr[i] = mat[r][c];

        	// Going up diagonal (index sums to even)
        	if ((r + c) % 2 == 0) {
        		// If last column, move to next row in same column
        		if (c == numCols - 1) 	{ r++; }
        		// If first row, move to next col in same row
        		else if (r == 0) 		{ c++; }
        		// Go up diagonally (Move previous row, next column)
        		else 					{r--; c++;};
        	} else {	// Going down diagonal (index sums to odd)
        		// If last row, move to next col in same row
        		if (r == numRows - 1)	{ c++; }
                // If first col, move to next row in same col
        		else if (c == 0) 		{ r++; }
        		// Go down diagonally (Move to next row, prev col)
        		else 					{r++; c--;};
        	}
        }

        return arr;
    }

    public static void main(String[] args) {
    	int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
    	int[] arr = findDiagonalOrder(mat);
    	for(int i: arr) System.out.print(i + " ");
    }
}