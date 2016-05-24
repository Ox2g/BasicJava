package me.code41.algorithm.reverseTree;

/**
 * Created by liushiyao on 2016/5/23.
 */
public class ReverseTree {
    public static void main(String[] args) {
        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(5);
        TreeNode i = new TreeNode(4);
        TreeNode j = new TreeNode(2);
        TreeNode f = new TreeNode(3, null, j);
        TreeNode c = new TreeNode(8, null, f);
        TreeNode e = new TreeNode(6, h, i);
        TreeNode d = new TreeNode(7, g, null);
        TreeNode b = new TreeNode(9, d, e);
        TreeNode a = new TreeNode(10, b, c);

        TreeNode.reverseTree(a);
        System.out.println(a);
    }
}
