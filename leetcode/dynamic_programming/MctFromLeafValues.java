/*
1130. Minimum Cost Tree From Leaf Values
Solved
Medium
Topics
Companies
Hint
Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.
*/

class MctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        return recurse(arr, 0, arr.length - 1, dp);
    }

    public int recurse(int[] arr, int start, int end, int[][] dp) {
        if (start == end) return 0;
        if (dp[start][end] > 0) return dp[start][end];

        int minCost = Integer.MAX_VALUE;
        for(int k = start; k < end; k++) {
            int costLeft = recurse(arr, start, k, dp);
            int costRight= recurse(arr, k + 1, end, dp);

            int maxLeft = findMax(arr, start, k);
            int maxRight = findMax(arr, k + 1, end);

            minCost = Math.min(minCost, costLeft + costRight + (maxLeft * maxRight));
        }
        dp[start][end] = minCost;
        return dp[start][end];
    }

    public int findMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) max = Math.max(max, arr[i]);
        return max;
    }
}