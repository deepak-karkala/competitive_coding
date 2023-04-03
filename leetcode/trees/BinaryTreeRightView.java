/*
199. Binary Tree Right Side View
Medium
9.7K
583
Companies
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
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
 
public class BinaryTreeRightView {
	private static List<Integer> rightSideView(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();

		List<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()){

			TreeNode rightModeNode = queue.poll();
			list.add(rightModeNode.val);

			int size = queue.size();

			if (rightModeNode.right != null) queue.offer(rightModeNode.right);
			if (rightModeNode.left != null) queue.offer(rightModeNode.left);

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if (node.right != null) queue.offer(node.right);
				if (node.left != null) queue.offer(node.left);
			}

		}
		return list;
	}

	private static void rightSideViewRecurse(TreeNode root, List<Integer> list) {
		if(root != null) {
			list.add(root.val);
			rightSideViewRecurse(root.right, list);
		}        
    }

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(2, null, new TreeNode(5));
    	TreeNode right = new TreeNode(3, null, new TreeNode(4));
    	TreeNode root = new TreeNode(1, left, null);
    	System.out.println(rightSideView(root));
    }
}