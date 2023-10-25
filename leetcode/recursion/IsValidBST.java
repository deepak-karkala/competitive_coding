/*
98. Validate Binary Search Tree
Medium
Topics
Companies
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees
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

class IsValidBST {
    private static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean isLeftValidBST = isValidBST(root.left);
        boolean isRightValidBST = isValidBST(root.right);

        int maxLeft = get_max_tree(root.left);
        int minRight = get_min_tree(root.right);

        boolean cond1 = true;
        if (root.left != null && root.val <= maxLeft) cond1 = false;
        boolean cond2 = true;
        if (root.right != null && root.val >= minRight) cond2 = false;

        return (cond1 && cond2 && isLeftValidBST && isRightValidBST);
    }

    private static int get_max_tree(TreeNode root) {
    	int max = Integer.MIN_VALUE;
    	if (root != null) {
    		int max_left_subtree = get_max_tree(root.left);
    		int max_right_subtree = get_max_tree(root.right);
    		max = Math.max(max, root.val);
    		max = Math.max(max, max_left_subtree);
    		max = Math.max(max, max_right_subtree);
    	}
    	return max;
    }

    private static int get_min_tree(TreeNode root) {
    	int min = Integer.MAX_VALUE;
    	if (root != null) {
    		int min_left_subtree = get_min_tree(root.left);
    		int min_right_subtree = get_min_tree(root.right);
    		min = Math.min(min, root.val);
    		min = Math.min(min, min_left_subtree);
    		min = Math.min(min, min_right_subtree);
    	}
    	return min;
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
    	System.out.println(isValidBST(root));
    }
}

