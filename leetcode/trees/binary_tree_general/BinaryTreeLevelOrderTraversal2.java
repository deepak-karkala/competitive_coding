/*
107. Binary Tree Level Order Traversal II
Medium
4.2K
308
Companies
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
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
 
public class BinaryTreeLevelOrderTraversal2 {
	private static List<List<Integer>> levelOrderBottomIterative(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;

		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> listLevel = new ArrayList<Integer>();

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				listLevel.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right!= null) queue.offer(node.right);
			}
			list.add(0, listLevel);

		}
		return list;
	}

	private static List<List<Integer>> levelOrderBottomRecursive(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		levelOrderBottomRecurse(root, list, 0);
		return list;
	}

	private static void levelOrderBottomRecurse(TreeNode root, List<List<Integer>> list, int level) {
		if (root == null) return;

		if (list.size() == level) {
			List<Integer> listLevel = new ArrayList<Integer>();
			listLevel.add(root.val);
			list.add(0, listLevel);
		} else {
			list.get(list.size()-level-1).add(root.val);
		}
		levelOrderBottomRecurse(root.left, list, level+1);
		levelOrderBottomRecurse(root.right, list, level+1);

		return;
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(9, null, null);
    	TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
    	TreeNode root = new TreeNode(3, left, right);
    	System.out.println(levelOrderBottomRecursive(root));
    }
}