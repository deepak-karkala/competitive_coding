/*
95. Unique Binary Search Trees II
Medium
Topics
Companies
Given an integer n, return all the structurally unique BST's
(binary search trees), which has exactly n nodes of unique values from 1 to n.
Return the answer in any order.
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

class UniqueBST2 {
	/*
		Recursively generate left and right subtrees
	*/
    private static List<TreeNode> generateTrees(int n) {
        return generateTreesRecursive(1, n);
    }

    private static List<TreeNode> generateTreesRecursive(int start, int end) {
    	List<TreeNode> res = new ArrayList<TreeNode>();

    	if (start > end) {
    		res.add(null);
    		return res;
    	}

    	for(int i=start; i<=end; i++) {
    		List<TreeNode> leftSubtrees = generateTreesRecursive(start, i-1);
    		List<TreeNode> rightSubtrees = generateTreesRecursive(i+1, end);

    		// Create all combinations of left and right subtrees
    		for(TreeNode left: leftSubtrees)
    			for(TreeNode right: rightSubtrees) {
    				TreeNode root = new TreeNode(i);
    				root.left = left;
    				root.right = right;
    				res.add(root);
    			}
    	}
    	return res;
    }

    public static void main(String[] args) {
    	int n = 3;
    	List<TreeNode> nodes = generateTrees(n);
    	for(TreeNode node: nodes) {
    		printBST(node);
    		System.out.println("");
    	}
    }

    private static void printBST(TreeNode node) {
    	if (node != null) {
    		System.out.print(node.val);
    		printBST(node.left);
    		printBST(node.right);
    	}
    }
}