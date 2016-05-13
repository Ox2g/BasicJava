package me.code41.algorithm.basic.tree;

/**
 * Created by liushiyao on 2016/5/13.
 */
public class BinTreeNode {
    public int value;
    public BinTreeNode leftBinTreeNode;
    public BinTreeNode rightBinTreeNode;

    public BinTreeNode(int value) {
        this.value = value;
    }

    public BinTreeNode(int value, BinTreeNode leftBinTreeNode, BinTreeNode rightBinTreeNode) {
        this.value = value;
        this.leftBinTreeNode = leftBinTreeNode;
        this.rightBinTreeNode = rightBinTreeNode;
    }
}
