/*
235. Lowest Common Ancestor of a Binary Search Tree
Solved
Medium
Topics
Companies
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
*/

class LCABst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // If root exists between nodes p and q, return root
        if ((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) return root;
        // If root is greater than both p and q, search in left subtree
        else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        // If root is lesser than both p and q, search in right subtree
        else return lowestCommonAncestor(root.right, p, q);
    }
}