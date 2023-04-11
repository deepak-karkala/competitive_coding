/*
101. Symmetric Tree
Easy
13.2K
296
Companies
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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

public class SymmetricTree {

	// Recursive solution
	private static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetricRecurse(root.left, root.right);
	}

	private static boolean isSymmetricRecurse(TreeNode left, TreeNode right) {
		if (right==null && left==null) return true;
		if (right==null || left==null) return false;

		if (left.val != right.val) return false;

		return isSymmetricRecurse(left.left, right.right) && isSymmetricRecurse(left.right, right.left);
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
    	TreeNode right = new TreeNode(2, new TreeNode(3), new TreeNode(4));
    	TreeNode root = new TreeNode(1, left, right);
    	System.out.println(isSymmetric(root));
    }
}