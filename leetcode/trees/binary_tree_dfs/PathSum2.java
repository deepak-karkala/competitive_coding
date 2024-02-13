/*113. Path Sum II
Medium
6.9K
139
Companies
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths
where the sum of the node values in the path equals targetSum. Each path should be returned
as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf
is a node with no children.
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
 
public class PathSum2 {
	private static List<List<Integer>> pathSumBacktrack1(TreeNode root, int targetSum) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		if (root == null) return sets;

		List<TreeNode> subset = new ArrayList<TreeNode>();
		subset.add(root);
		backtrack(sets, subset, targetSum);
		return sets;
	}

	private static void backtrack(List<List<Integer>> sets, List<TreeNode> subset, int targetSum) {
		// check if leaf node is reached (the last node added in subset)
		TreeNode node = subset.get(subset.size()-1);
		
		if (node.left == null && node.right == null) {
			List<Integer> list = new ArrayList<Integer>();
			int pathSum = 0;
			for(int i=0; i<subset.size(); i++) {
				pathSum += subset.get(i).val;
				list.add(subset.get(i).val);
			}
			// If current pathsum equals to target sum then add it to final result set
			if (pathSum == targetSum) {
				sets.add(new ArrayList<>(list));
			}
		} else {
			// Add left subtree and backtrack
			if (node.left != null) {
				subset.add(node.left);
				backtrack(sets, subset, targetSum);
				subset.remove(subset.size()-1);
			}

			// Add right subtree and backtrack
			if (node.right != null) {
				subset.add(node.right);
				backtrack(sets, subset, targetSum);
				subset.remove(subset.size()-1);
			}
		}
		return;
	}


	private static List<List<Integer>> pathSumBacktrack2(TreeNode root, int targetSum) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		List<Integer> subset = new ArrayList<Integer>();
		if (root == null) return sets;
		backtrack2(root, sets, subset, targetSum);
		return sets;
	}

	private static void backtrack2(TreeNode node, List<List<Integer>> sets, List<Integer> subset, int remainingSum) {
		if (node == null) return;
		subset.add(node.val);

		// check if leaf node is reached (the last node added in subset)
		if (node.val == remainingSum && node.left == null && node.right == null) {
			sets.add(new ArrayList<>(subset));
		} else {
			// Add left subtree and backtrack
			backtrack2(node.left, sets, subset, remainingSum - node.val);
			backtrack2(node.right, sets, subset, remainingSum - node.val);
		}
		subset.remove(subset.size()-1);
		return;
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
    	TreeNode right = new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)));
    	TreeNode root = new TreeNode(5, left, right);
    	System.out.println(pathSumBacktrack1(root, 22));
    }
}
