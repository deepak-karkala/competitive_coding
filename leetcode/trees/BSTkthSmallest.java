/*
230. Kth Smallest Element in a BST
Medium
9.5K
166
Companies
Given the root of a binary search tree, and an integer k, return the kth smallest
value (1-indexed) of all the values of the nodes in the tree.
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
 
public class BSTkthSmallest {
	private static int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		inOrderTraversal(root, list);
		return list.get(k-1);
	}

	private static void inOrderTraversal(TreeNode root, List<Integer> list){
		if(root != null){
			inOrderTraversal(root.left, list);
			list.add(root.val);
			inOrderTraversal(root.right, list);
		}
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null),  new TreeNode(4));
    	TreeNode right = new TreeNode(6);
    	TreeNode root = new TreeNode(5, left, right);

    	System.out.println(kthSmallest(root, 3));
    }
}