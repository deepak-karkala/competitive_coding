/*
103. Binary Tree Zigzag Level Order Traversal
Medium
9.1K
239
Companies
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
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
 
public class BinaryTreeZigzagLevelOrderTraversal {

	// Iterative using two stacks
	private static List<List<Integer>> zigzagLevelOrderIterative(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;

		Deque<TreeNode> oddLevelStack = new LinkedList<TreeNode>();
		Deque<TreeNode> evenLevelStack = new LinkedList<TreeNode>();
		evenLevelStack.push(root);
		int depth = 0;

		while(!evenLevelStack.isEmpty() || !oddLevelStack.isEmpty()) {
			List<Integer> levelList = new ArrayList<Integer>();
			int size = 0;

			if (depth % 2 ==0) size = evenLevelStack.size();
			else size = oddLevelStack.size();

			for (int i=0; i<size; i++) {
				if (depth % 2 == 0) {
					TreeNode node = evenLevelStack.pop();
					if (node==null) continue;
					levelList.add(node.val);
					oddLevelStack.push(node.left);
					oddLevelStack.push(node.right);
				} else {
					TreeNode node = oddLevelStack.pop();
					if (node==null) continue;
					levelList.add(node.val);
					evenLevelStack.push(node.right);
					evenLevelStack.push(node.left);
				}
			}
			if (!levelList.isEmpty()) list.add(new ArrayList<>(levelList));
			depth += 1;
		}
		return list;
	}

	// Iterative using single queue
	private static List<List<Integer>> zigzagLevelOrderIterative2(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 0;

		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				
				if (depth%2 == 1) levelList.add(node.val);
				else levelList.add(0, node.val);

				if (node.right != null) queue.offer(node.right);
				if (node.left != null) queue.offer(node.left);
			}
			list.add(new ArrayList<>(levelList));
			depth++;
		}
		return list;
	}

	// Recursive
	private static List<List<Integer>> zigzagLevelOrderRecursive(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		zigzagLevelOrderRecurse(root, list, 0);
		return list;
	}

	private static void zigzagLevelOrderRecurse(TreeNode node, List<List<Integer>> list, int level) {
		if (node == null) return;

		if (list.size() == level) {
			List<Integer> levelList = new ArrayList<Integer>();
			levelList.add(node.val);
			list.add(new ArrayList<>(levelList));
		} else {
			if (level%2==0) list.get(level).add(0, node.val);
			else list.get(level).add(node.val);
		}
		zigzagLevelOrderRecurse(node.right, list, level+1);
		zigzagLevelOrderRecurse(node.left, list, level+1);
		return;
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(9, new TreeNode(5), new TreeNode(4));
    	TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
    	TreeNode root = new TreeNode(3, left, right);
    	System.out.println(zigzagLevelOrderRecursive(root));
    }
}