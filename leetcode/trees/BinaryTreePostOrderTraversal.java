/*
145. Binary Tree Postorder Traversal
Easy
5.8K
168
Companies
Given the root of a binary tree, return the postorder traversal of its nodes' values.
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
 
public class BinaryTreePostOrderTraversal {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postorderTraversalRecursive(root, list);
		return list;
	}

	public static void postorderTraversalRecursive(TreeNode root, List<Integer>list){
		if (root != null){
			postorderTraversalRecursive(root.left, list);
			postorderTraversalRecursive(root.right, list);
			list.add(root.val);
		}
	}

	public static void main(String[] args){
    	TreeNode left = new TreeNode(4, null, null);
    	TreeNode right = new TreeNode(2, new TreeNode(3), null);
    	TreeNode root = new TreeNode(1, left, right);
    	List<Integer> list = postorderTraversal(root);
    	System.out.println(list);
    }
}