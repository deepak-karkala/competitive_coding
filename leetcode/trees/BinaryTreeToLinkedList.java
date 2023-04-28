/*
114. Flatten Binary Tree to Linked List
Medium
10.4K
511
Companies
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
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
 
public class BinaryTreeToLinkedList {
	private static TreeNode flatten(TreeNode root) {
		recurse(root);
		return root;
	}

	// Naive approach
	// Space: O(n) since it is in-place
	// Time: O(n*h) because of finding rightMostInLeftSubtree for every node
	// 		Best case time: O(nlogn), Worst case: O(n^2)
	private static TreeNode recurse(TreeNode node) {
		if (node == null) return null;
		if (node.left==null && node.right==null) return node;

		TreeNode rightMostInLeftSubtree = recurse(node.left);
		TreeNode tmp = recurse(node.right);

		if (rightMostInLeftSubtree != null) {
			rightMostInLeftSubtree.right = node.right;
			node.right = node.left;
		}
		node.left = null;

		while(node.right != null) node = node.right;
		return node;
	}

	private static void inOrderTraversal(TreeNode root) {
		if (root == null) return;
		System.out.println(root.val);
		inOrderTraversal(root.left);
		inOrderTraversal(root.right);
		return;
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
    	TreeNode right = new TreeNode(5, null, new TreeNode(6));
    	TreeNode root = new TreeNode(1, left, right);
    	//inOrderTraversal((root));
    	inOrderTraversal(flatten(root));
    }
}