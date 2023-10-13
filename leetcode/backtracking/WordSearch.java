/*
79. Word Search
Medium
Topics
Companies
Given an m x n grid of characters board and a string word, return true if
word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. The same
letter cell may not be used more than once.
*/

class WordSearch {
	/* Approach: DFS / Backtrack
		1. Start from each cell which contains first character in the target word.
		2. Backtrack in all 4 directions
			a. Return false if out of bounds or if character at that index does not
				match the one in word
		3. Use a visited array to track if cell has been visited.
			As we come up the recursive path, set visited of that cell to false
				since the same cell may be part of the solution in another DFS path.
	*/
    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];

        // Start searching from every position which contains
        // the first letter in the word 'word'
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (board[i][j] == word.charAt(0) && backtrack(board, word, i, j, used, 0))
        			return true;
        	}
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word,
    	int i, int j, boolean[][] used, int index) {
    	// Word found, return true
    	if (index == word.length()) return true;

		int m = board.length;
        int n = board[0].length;

        // If out of bounds or if this cell is already visited, then return
        if (i<0 || j<0 || i>=m || j>=n || used[i][j]) return false;
        if (word.charAt(index) != board[i][j]) return false;

        // Mark this cell as visited
        used[i][j] = true;
        // Recurse in all 4 directions
        boolean isExist = backtrack(board, word, i+1, j, used, index+1)
	        || backtrack(board, word, i-1, j, used, index+1)
	        || backtrack(board, word, i, j-1, used, index+1)
        	|| backtrack(board, word, i, j+1, used, index+1);
	        
	    used[i][j] = false;

        return isExist;
    }

    public static void main(String[] args) {
    	char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	//char[][] board = {{'a', 'b'}, {'c','d'}};
    	String word = "ABCCED";
    	System.out.println(exist(board, word));
    }
}

