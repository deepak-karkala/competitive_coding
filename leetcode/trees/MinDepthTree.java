/*
111. Minimum Depth of Binary Tree
Easy
5.5K
1.1K
Companies
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
*/

public class MinDepthTree {
	public static int minDepth(TreeNode root){
		// Base case
		if (root == null) return 0;

		// If one of the subtree is null, then return minDepth of other subtree
		// This is because we have to traverse to leaf node (one with no child tree)
		if (root.left == null) return minDepth(root.right)+1;
		if (root.right == null) return minDepth(root.left)+1;

		// Only when both subtrees are not null, we return min of minDepth of two subtrees
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	} 

	public static void main(String[] args) {
		TreeNode left = new TreeNode();
    	TreeNode right = new TreeNode(3, new TreeNode(15), new TreeNode(7));
    	TreeNode root = new TreeNode(2, left, right);
    	System.out.println(minDepth(root));
	}
}