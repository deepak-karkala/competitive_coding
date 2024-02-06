/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Solved
Medium
Topics
Companies
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
*/

class BuildTreePreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }

    private static TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) return null;

        // postEnd gives root node
        TreeNode root = new TreeNode(preorder[preStart]);
        // Find index of root in inorder,
        //      inStart to rootIndex-1 will be left subtree
        //      rootIndex+1 to inEnd will be right subtree
        int rootIdx = -1;
        for(int i=inStart; i<=inEnd; i++)
            if (inorder[i] == root.val) {rootIdx = i; break;}
        
        // Determine sizes of left and right subtrees to set indices in postorder array
        int leftTreeSize = rootIdx - inStart;
        int rightTreeSize = inEnd - rootIdx;

        // Build left and right subtrees recursively
        root.left = buildTree(inorder, preorder, inStart, rootIdx-1, preStart+1, preStart + leftTreeSize);
        root.right =  buildTree(inorder, preorder, rootIdx+1, inEnd, preStart + leftTreeSize + 1, preEnd);

        return root;
    }
}