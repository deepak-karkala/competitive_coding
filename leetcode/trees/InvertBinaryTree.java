/*
226. Invert Binary Tree
Easy
11.9K
167
Companies
Given the root of a binary tree, invert the tree, and return its root.
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


public class InvertBinaryTree {

	public static TreeNode invertTree(TreeNode root) {
		if (root != null){
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}

	// For printing tree
    public static List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrderTraversalRecursive(root, list);
		return list;
	}

	public static void inOrderTraversalRecursive(TreeNode root, List<Integer> list) {
		if (root != null) {
			inOrderTraversalRecursive(root.left, list);
			list.add(root.val);
			inOrderTraversalRecursive(root.right, list);
		}
	}

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    	TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
    	TreeNode root = new TreeNode(4, left, right);
    	System.out.println(inOrderTraversal(root));
    	TreeNode invert = invertTree(root);
    	System.out.println(inOrderTraversal(invert));
	}
}