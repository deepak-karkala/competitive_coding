/*
1448. Count Good Nodes in Binary Tree
Solved
Medium
Topics
Companies
Hint
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree
*/

class GoodNodes {
	// DFS
	// Time: O(n) Space: O(h)
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int max) {
        int numGoodNodes = 0;
        if (root == null) return numGoodNodes;
        if (root.val >= max) numGoodNodes++;
        numGoodNodes += goodNodes(root.left, Math.max(max, root.val));
        numGoodNodes += goodNodes(root.right, Math.max(max, root.val));
        return numGoodNodes;
    }
}