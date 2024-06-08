/*
1039. Minimum Score Triangulation of Polygon
Medium
Topics
Companies
Hint
You have a convex n-sided polygon where each vertex has an integer value. You are given an integer array values where values[i] is the value of the ith vertex (i.e., clockwise order).

You will triangulate the polygon into n - 2 triangles. For each triangle, the value of that triangle is the product of the values of its vertices, and the total score of the triangulation is the sum of these values over all n - 2 triangles in the triangulation.

Return the smallest possible total score that you can achieve with some triangulation of the polygon.
*/

class MinScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] memo = new int[n][n];
        return dp(values, 0, n - 1, memo);
    }

    public int dp(int[] values, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];

        // Base case, cannot form triangle
        if (j - i < 2) return 0;

        int score = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++) {
            score = Math.min(score, values[i] * values[j] * values[k] + dp(values, i, k, memo) + dp(values, k, j, memo));
        }
        return memo[i][j] = score;
    }
}