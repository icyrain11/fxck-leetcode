package org.icyrain11.leetcode.treenode;

/**
 * @author icyrain11
 * @version 17
 */
public class TreeNode {
   public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
