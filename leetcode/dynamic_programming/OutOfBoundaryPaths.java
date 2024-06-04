/*
576. Out of Boundary Paths
Solved
Medium
Topics
Companies
Hint
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
*/

class OutOfBoundaryPaths {
    final int mod = 1000000000 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] memo = new Integer[m][n][maxMove + 1];
        return countPaths(m, n, maxMove, startRow, startColumn, memo);
    }

    public int countPaths(int m, int n, int numMoves, int i, int j, Integer[][][] memo) {
        // Out of boundary cell, increment count by 1
        if (i < 0 || j < 0 || i == m || j == n) return 1;
        
        // Return memoised count
        if (memo[i][j][numMoves] != null) return memo[i][j][numMoves];

        // If number of remaining moves becomes 0, stop recursing, return 0
        if (numMoves == 0) return 0;

        // Move ball in all 4 directions
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int numPaths = 0;
        for (int[] dir: dirs)
            numPaths = (numPaths + 
                countPaths(m, n, numMoves - 1, i + dir[0], j + dir[1], memo)
                ) % mod;
        
        return memo[i][j][numMoves] = numPaths;
    }
}