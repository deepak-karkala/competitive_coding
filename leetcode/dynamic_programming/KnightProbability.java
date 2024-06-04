/*
688. Knight Probability in Chessboard
Solved
Medium
Topics
Companies
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.
*/

class KnightProbability {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return knightProbability(n, k, row, column, memo);
    }

    public double knightProbability(int n, int k, int r, int c, double[][][] memo) {
        // Goes out of board, do not count these possibilities
        if (r < 0 || r >= n || c < 0 || c >= n) return 0;
        // When k (number of moves) reaches 0 and if knight ends up on board, then
        //      count this as one 
        if (k == 0) return 1;
        // Return memoized probability value
        if (memo[r][c][k] != 0) return memo[r][c][k];

        // Take a step in each of the 8 directions
        //      Add up the probabilities, each direction has a chance 1/8
        // 8 directions (possibilities) for knight's move
        int[][] dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
        double prob = 0;
        for(int i = 0; i < dir.length; i++)
            prob += (1 / 8.0) * knightProbability(n, k - 1, r + dir[i][0], c + dir[i][1], memo);
        memo[r][c][k] = prob;
        return prob;
    }
}