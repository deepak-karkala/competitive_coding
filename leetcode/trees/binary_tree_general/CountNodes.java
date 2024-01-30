/*
222. Count Complete Tree Nodes
Solved
Easy
Topics
Companies
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.
*/


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root.left, right = root.right;
        int height = 0;
        while(left != null && right != null) {
            height++;
            left = left.left;
            right = right.right;
        }

        return (left == right) ? (1<<height+1)-1 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}