/*
236. Lowest Common Ancestor of a Binary Tree
Medium
13.8K
329
Companies
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
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
 
public class BinaryTreeLCA {
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
        if (root==null || root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left!=null ? left : right;
    }

    public static void main(String[] args) {
    	TreeNode left = new TreeNode(9, new TreeNode(5), new TreeNode(4));
    	TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
    	TreeNode root = new TreeNode(3, left, right);
    }
}