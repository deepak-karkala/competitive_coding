/*
104. Maximum Depth of Binary Tree
Easy
10.4K
165
Companies
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from
the root node down to the farthest leaf node.
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
 
public class MaxDepthTree {

	/*
	Approach - recursive
		Base case: If both children are null, return 1
		Get depths of left and right child. Return max(left.dpeth, right.depth)+1
	*/
    public static int maxDepthRecursive(TreeNode root) {
    	// Base case
    	if (root == null) return 0;
        //if (root.left == null && root.right == null) return 1;


    	/*
        int leftDepth = 0, rightDepth = 0;
        leftDepth = maxDepthRecursive(root.left);
        rightDepth = maxDepthRecursive(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
        */
        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;

    }

    public static void main(String[] args) {
    	TreeNode left = new TreeNode(9);
    	TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
    	TreeNode root = new TreeNode(3, left, right);
    	System.out.println(maxDepthRecursive(root));
    }
}