/*
700. Search in a Binary Search Tree
Easy
Topics
Companies
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the
subtree rooted with that node. If such a node does not exist, return null
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

class SearchBST {
	/* Recursion */
    private static TreeNode searchBSTRecursive(TreeNode root, int val) {
    	if (root == null) return null;

    	if (val == root.val) {
    		return root;
    	} else if (val > root.val) {
    		return searchBSTRecursive(root.right, val);
    	} else {
    		return searchBSTRecursive(root.left, val);
    	}
    }

    /* Iteration */
    private static TreeNode searchBSTIterative(TreeNode root, int val) {
    	while (root != null) {
    		if (root.val == val) {
    			return root;
    		} else if (val > root.val) {
    			root = root.right;
    		} else {
    			root = root.left;
    		}
    	}
    	return root;
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
    	int val = 2;
    	TreeNode node = searchBSTIterative(root, val);
    	printBST(node);
    }

    private static void printBST(TreeNode node) {
    	if (node != null) {
    		System.out.println(node.val);
    		printBST(node.left);
    		printBST(node.right);
    	}
    }
}