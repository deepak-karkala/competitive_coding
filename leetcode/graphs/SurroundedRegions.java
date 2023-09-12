/*
130. Surrounded Regions
Medium
7.9K
1.6K
Companies
Given an m x n matrix board containing 'X' and 'O', capture all regions that are
4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/

class SurroundedRegions {
	/* Approach: DFS from boundary
		Mark boundary 'O' as '*', run dfs around those 'O's and recursively mark those 'O' as '*'
		Mark (Capture) remaining 'O' as 'X', change '*' back to 'O'
	*/
    private static void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) return;
        int m = board.length, n = board[0].length;

        // Mark boundary 'O' as '*', run dfs around those 'O's and recursively mark those 'O' as '*'
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (i==0 || j==0 || i==m-1 || j==n-1) dfs(board, i, j);
        	}
        }

        // Mark (Capture) remaining 'O' as 'X', change '*' back to 'O'
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (board[i][j] == 'O') {
        			board[i][j] = 'X';
        		} else if (board[i][j] == '*') {
        			board[i][j] = 'O';
        		}
        	}
        }
    }

    private static void dfs(char[][] board, int i, int j){
    	// Return if out of bounds or if current position is not 'O'
    	if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O') return;

    	board[i][j] = '*';
    	dfs(board, i-1, j);
    	dfs(board, i+1, j);
    	dfs(board, i, j-1);
    	dfs(board, i, j+1);
    }

    public static void main(String[] args) {
    	char[][] board = { {'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'} };
    	solve(board);
    	for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
	        	System.out.print(board[i][j] + " ");
        	}
        	System.out.println("");
        }
    }
}