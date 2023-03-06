package com.obeast.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wxl
 * Date 2023/3/6 10:51
 * @version 1.0
 * Description:
 */
public class MirrorTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), true),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        mirrorTreeBfs(treeNode);
    }
    public static TreeNode mirrorTree(TreeNode root) {
       if (root == null) return null;
        TreeNode leftTemp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(leftTemp);
        return root;
    }

    public static TreeNode mirrorTreeBfs(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;

    }
}
