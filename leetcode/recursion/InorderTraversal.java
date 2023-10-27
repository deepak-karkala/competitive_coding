/*
94. Binary Tree Inorder Traversal
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values
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

class InorderTraversal {
	/* Recursive */
    private static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recurse(root, list);
        return list;
    }

    private static void recurse(TreeNode root, List<Integer> list) {
    	if (root == null) return;
        recurse(root.left, list);
        list.add(root.val);
        recurse(root.right, list);
        return;
    }

    /* Iterative */
    private static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;

    	Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode node = root;

    	while(node!=null || !stack.isEmpty()) {
	    	// Traverse to left most node in the tree
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}

    		node = stack.pop();
    		list.add(node.val);
    		node = node.right;
    	}
    	return list;
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
    	List<Integer> list = inorderTraversalIterative(root);
    	for(int i: list) System.out.print(i + " ");
    }
}