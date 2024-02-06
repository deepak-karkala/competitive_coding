/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Solved
Medium
Topics
Companies
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
*/

class BuildTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;

        // postEnd gives root node
        TreeNode root = new TreeNode(postorder[postEnd]);
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
        root.left = buildTree(inorder, postorder, inStart, rootIdx-1, postStart, postStart + leftTreeSize - 1);
        root.right =  buildTree(inorder, postorder, rootIdx+1, inEnd, postEnd - rightTreeSize, postEnd - 1);

        return root;
    }
}