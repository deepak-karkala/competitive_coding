/*
94. Binary Tree Inorder Traversal
Easy
11.1K
543
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values.
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


public class BinaryTreeInOrderTraversal {
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

	public static List<Integer> inOrderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr = root;

		while(curr!=null || !stack.isEmpty()){
			while(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;
		}
		int[] arr = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			arr[i] = list.get(i);
		}
		return list;
	}

	public static void main(String[] args){
    	TreeNode left = new TreeNode(4, null, null);
    	TreeNode right = new TreeNode(2, new TreeNode(3), null);
    	TreeNode root = new TreeNode(1, left, right);
    	List<Integer> list = inOrderTraversalIterative(root);
    	System.out.println(list);
    }
}