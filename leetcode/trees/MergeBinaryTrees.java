/*
617. Merge Two Binary Trees
Easy
8K
277
Companies
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees
are overlapped while the others are not. You need to merge the two trees into a new
binary tree. The merge rule is that if two nodes overlap, then sum node values up as
the new value of the merged node. Otherwise, the NOT null node will be used as the node
of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
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

public class MergeBinaryTrees {
	private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null) return null;

        if (root1==null) return root2;
        if (root2==null) return root1;

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
    }

	// For printing tree
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

	public static void main(String[] args) {
		TreeNode left = new TreeNode(3, new TreeNode(5), null);
    	TreeNode right = new TreeNode(2, null, null);
    	TreeNode root1 = new TreeNode(1, left, right);

    	left = new TreeNode(1, null, new TreeNode(4));
    	right = new TreeNode(3, null, new TreeNode(7));
    	TreeNode root2 = new TreeNode(2, left, right);

    	System.out.println(inOrderTraversal(root1));
    	System.out.println(inOrderTraversal(root2));
    	TreeNode root = mergeTrees(root1, root2);
    	System.out.println(inOrderTraversal(root));
	}
}