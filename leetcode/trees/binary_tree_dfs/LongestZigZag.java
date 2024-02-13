/*
1372. Longest ZigZag Path in a Binary Tree
Solved
Medium
Topics
Companies
Hint
*/

class LongestZigZag {
    // DFS
    // Time: O(n) Space:O(height)
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        return Math.max(longestZigZag(root.left, "left", 0), longestZigZag(root.right, "right", 0));
    }

    public int longestZigZag(TreeNode root, String dir, int currDepth) {
        if (root == null) return currDepth;
        int maxDepthLeft = longestZigZag(root.left, "left", dir.equals("left") ? 0 : currDepth+1);
        int maxDepthRight = longestZigZag(root.right, "right", dir.equals("right") ? 0 : currDepth+1);
        return Math.max(maxDepthLeft, maxDepthRight);
    }
}