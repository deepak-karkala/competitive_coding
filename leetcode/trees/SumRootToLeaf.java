/*129. Sum Root to Leaf Numbers
Medium
6.6K
100
Companies
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that
the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
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
 
public class SumRootToLeaf {
	private static int sumNumbers(TreeNode root) {
		int sumCurrPath = 0;
		ArrayList<Integer> sumPaths = new ArrayList<Integer>();
		backtrack(root, sumPaths, sumCurrPath);
		int sumAllPaths = 0;
		for(int sum: sumPaths) {
			sumAllPaths += sum;
		}
		return sumAllPaths;
	}

	private static void backtrack(TreeNode node, ArrayList<Integer> sumPaths, int sumCurrPath) {
		if (node == null) return;

		int prevSumCurrPath = sumCurrPath;
		sumCurrPath = sumCurrPath*10 + node.val;

		// If leaf node, add current sum path to overall sum
		if (node.left==null && node.right==null) {
			sumPaths.add(sumCurrPath);
		} else {
			backtrack(node.left, sumPaths, sumCurrPath);
			backtrack(node.right, sumPaths, sumCurrPath);
		}
		sumCurrPath = prevSumCurrPath;
		return;
	}

	public static void main(String[] args) {
    	TreeNode left = new TreeNode(9, new TreeNode(5), new TreeNode(1));
    	TreeNode right = new TreeNode(0, null, null);
    	TreeNode root = new TreeNode(4, left, right);
    	System.out.println(sumNumbers(root));
    }

}