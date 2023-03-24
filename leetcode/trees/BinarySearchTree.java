/*
Binary Search Tree
*/

class TreeNode {
	public int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	public void printTreeNode(){
		if (this != null) System.out.println(this.val);
		else System.out.println("Null node");
	}
}

public class BinarySearchTree {
	public TreeNode root;

	BinarySearchTree() {
		root = null;
	}

	BinarySearchTree(int[] arr) {
		root = sortedArrayToBst(arr, 0, arr.length-1);
	}

	private static TreeNode sortedArrayToBst(int[] arr, int low, int high){
		if (low > high) {
			return null;
		}
		int mid = (low + high)/2;
		TreeNode root = new TreeNode(arr[mid]);
		TreeNode left = sortedArrayToBst(arr, low, mid-1);
		TreeNode right = sortedArrayToBst(arr, mid+1, high);

		root.left = left;
		root.right = right;

		if(left != null) {
			left.parent = root;
		}

		if(right != null) {
			right.parent = root;
		}
		return root;
	}

	// In order traversal
	private static void inOrderTraversal(TreeNode root){
		if (root != null){
			inOrderTraversal(root.left);
			System.out.println(root.val);
			inOrderTraversal(root.right);
		}
	}

	// Pre order traversal
	private static void preOrderTraversal(TreeNode root){
		if (root != null){
			System.out.println(root.val);
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
		}
	}

	// Post order traversal
	private static void postOrderTraversal(TreeNode root){
		if (root != null){
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
			System.out.println(root.val);
		}
	}


	// Search for root with key
	private static TreeNode search(TreeNode root, int key) {
		TreeNode x = root;
		while(x != null) {
			if (key == x.val) {
				return x;
			} else if (key > x.val) {
				x = x.right;
			} else {
				x = x.left;
			}
		}
		return null;
	}

	// Minimum
	private static TreeNode minimum(TreeNode x) {
		while(x.left != null) {
			x = x.left;
		}
		return x;
	}

	// Maximum
	private static TreeNode maximum(TreeNode x) {
		while(x.right != null) {
			x = x.right;
		}
		return x;
	}

	// Successor
	private static TreeNode successor(TreeNode x) {
		// If right child is present, successor = min of right
		if (x.right != null) return minimum(x.right);

		TreeNode y = x.parent;
		while(y!=null && x==y.right){
			x = y;
			y = x.parent;
		}
		return y;
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 6, 7, 13, 15, 16, 17, 18, 19, 20, 21, 22};
		BinarySearchTree bst = new BinarySearchTree(arr);
		
		//inOrderTraversal(bst.root);
		
		//TreeNode x = search(bst.root, 14);
		//if (x != null) x.printTreeNode();

		TreeNode x = successor(bst.root);
		if (x != null) x.printTreeNode();

	}
}