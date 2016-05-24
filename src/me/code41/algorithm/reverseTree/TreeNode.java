package me.code41.algorithm.reverseTree;

/**
 * Created by liushiyao on 2016/5/12.
 */
public class TreeNode {
    public int value;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public static void reverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.leftNode == null && root.rightNode == null) {
            return;
        }
        TreeNode temp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = temp;
        reverseTree(root.leftNode);
        reverseTree(root.rightNode);
    }
}
