/*
110. Balanced Binary Tree
Easy
8.6K
487
Companies
Given a binary tree, determine if it is height-balanced
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
 
public class BalancedBinaryTree {

	private static boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int depthDiff = Math.abs(getDepth(root.left) - getDepth(root.right));
		if (depthDiff > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private static int getDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}


	public static void main(String[] args) {
    	//TreeNode left = new TreeNode(9);
    	//TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(10), null));
    	//TreeNode root = new TreeNode(3, left, right);

    	TreeNode left = new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)),  new TreeNode(3));
    	TreeNode right = new TreeNode(2);
    	TreeNode root = new TreeNode(1, left, right);

    	System.out.println(isBalanced(root));
    }
}