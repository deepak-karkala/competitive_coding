/*
993. Cousins in Binary Tree
Easy
3.5K
173
Companies
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
*/

import java.util.*;

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

public class CousinsBinaryTree {
	// Recursive
	static TreeNode xParent, yParent;
	static int xDepth=-1, yDepth=-1;

	private static boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, 0, x, y, null);
        return xDepth==yDepth && xParent!=yParent;
    }

	private static void getDepthAndParent(TreeNode root, int level, int x, int y, TreeNode parent) {
		if (root == null) return;

		if (root.val == x) {
			xParent = parent;
			xDepth = level;
		} else if (root.val == y) {
			yParent = parent;
			yDepth = level;
		} else {
			getDepthAndParent(root.left, level+1, x, y, root);
			getDepthAndParent(root.right, level+1, x, y, root);
		}
    }

	// Iterative
	private static boolean isCousinsIterative(TreeNode root, int x, int y) {
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 0, xdepth=-1, ydepth=-2;

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();

				// If cousins (found at same depth), return true
				if (node.val == x) xdepth = depth;
				if (node.val == y) ydepth = depth;
				if (xdepth == ydepth) return true;

				// If siblings, return false
				if (node.right != null && node.left != null) {
					if (node.right.val==x && node.left.val==y) return false;
					if (node.right.val==y && node.left.val==x) return false;
				}

				// Add left and right nodes to queue (to be processed at level depth+1)
				if (node.right != null) queue.offer(node.right);
				if (node.left != null) queue.offer(node.left);
			}
			depth += 1;
		}
		return false;
    }

    public static void main(String[] args) {
    	TreeNode left = new TreeNode(2, null, new TreeNode(4));
    	TreeNode right = new TreeNode(3, null, new TreeNode(5));
    	TreeNode root = new TreeNode(1, left, right);
    	System.out.println(isCousins(root, 4, 5));
    }
}