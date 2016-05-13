package me.code41.algorithm.publicParentNode;

import java.util.ArrayList;
import java.util.List;

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

    private static boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        boolean result = false;
        if (null != root) {
            if (root.value == target.value) {
                result = true;
            }
            if (!result && root.leftNode != null) {
                result = getPath(root.leftNode, target, path);

            }
            if (!result && root.rightNode != null) {
                result = getPath(root.rightNode, target, path);
            }
            if (result) {
                path.add(root);
            }
        }
        return result;
    }

    public static TreeNode getPublicParentNode(TreeNode root, TreeNode a, TreeNode b) {
        List<TreeNode> pathA = new ArrayList<>();
        List<TreeNode> pathB = new ArrayList<>();
        getPath(root, a, pathA);
        getPath(root, b, pathB);
        while (pathA.size() > 0 && pathB.size() > 0) {
            if (pathA.size() == pathB.size()) {
                if (pathA.get(0).value == pathB.get(0).value) {
                    return pathA.get(0);
                } else {
                    pathA.remove(0);
                    pathB.remove(0);
                }
            } else if (pathA.size() > pathB.size()) {
                pathA.remove(0);
            } else if (pathA.size() < pathB.size()) {
                pathB.remove(0);
            }
        }
        return null;
    }

}
