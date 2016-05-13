package me.code41.algorithm.basic.tree;


import java.util.LinkedList;

/**
 * Created by liushiyao on 2016/5/13.
 */
public class TreeTraverse {
    public static void main(String[] args) {
        BinTreeNode root = initTree();
        LinkedList<BinTreeNode> result = new LinkedList<>();
        postOrderTraverse(root, result);
        System.out.println("traverse result:");
        for (BinTreeNode binTreeNode : result) {
            System.out.print(binTreeNode.value + ",");
        }
    }

    private static BinTreeNode initTree() {
        BinTreeNode g = new BinTreeNode(1);
        BinTreeNode h = new BinTreeNode(5);
        BinTreeNode i = new BinTreeNode(4);
        BinTreeNode j = new BinTreeNode(2);
        BinTreeNode f = new BinTreeNode(3, null, j);
        BinTreeNode c = new BinTreeNode(8, null, f);
        BinTreeNode e = new BinTreeNode(6, h, i);
        BinTreeNode d = new BinTreeNode(7, g, null);
        BinTreeNode b = new BinTreeNode(9, d, e);
        BinTreeNode a = new BinTreeNode(10, b, c);
        System.out.println("\t\t\t\t\t10");
        System.out.println("\t\t9\t\t\t\t\t8");
        System.out.println("\t7\t\t\t6\t\t\t\t3");
        System.out.println("1\t\t\t5\t\t4\t\t\t\t2");
        return a;
    }

    public static void preOrderTraverse(BinTreeNode root, LinkedList<BinTreeNode> result) {
        result.add(root);
        if (root.leftBinTreeNode != null)
            preOrderTraverse(root.leftBinTreeNode, result);
        if (root.rightBinTreeNode != null)
            preOrderTraverse(root.rightBinTreeNode, result);
    }

    public static void preOrderTraverseWithoutRecursion(BinTreeNode root, LinkedList<BinTreeNode> result) {
    }

    public static void inOrderTraverse(BinTreeNode root, LinkedList<BinTreeNode> result) {
        if (root.leftBinTreeNode != null)
            inOrderTraverse(root.leftBinTreeNode, result);
        result.add(root);
        if (root.rightBinTreeNode != null)
            inOrderTraverse(root.rightBinTreeNode, result);
    }

    public static void postOrderTraverse(BinTreeNode root, LinkedList<BinTreeNode> result) {
        if (root.leftBinTreeNode != null)
            postOrderTraverse(root.leftBinTreeNode, result);
        if (root.rightBinTreeNode != null)
            postOrderTraverse(root.rightBinTreeNode, result);
        result.add(root);
    }
}
