package me.code41.algorithm.publicParentNode;

/**
 * Created by liushiyao on 2016/5/12.
 */
public class PublicParentNode {
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

        TreeNode result = TreeNode.getPublicParentNode(a, i, d);
        if (result.value == 9) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }

    }
}
