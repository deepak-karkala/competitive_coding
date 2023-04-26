/*
Consider lines of slope -1 passing between nodes.
Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.
(https://www.interviewbit.com/problems/diagonal-traversal/)
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
 
public class DiagonalTraverseTree {

	private static ArrayList<Integer> diagonalTraverseTree(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				while(node != null) {
					list.add(node.val);
					if (node.left != null) queue.offer(node.left);
					node = node.right;
				}
			}
		}
		/*
		int[] res = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
		}
		*/
		return list;
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(4, new TreeNode(8), new TreeNode(5, new TreeNode(9),  new TreeNode(7)));
    	TreeNode right = new TreeNode(2, null, new TreeNode(3, new TreeNode(6), null));
    	TreeNode root = new TreeNode(1, left, right);
    	System.out.println(diagonalTraverseTree(root));
    }
}