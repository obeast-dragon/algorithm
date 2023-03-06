package com.obeast.algorithm.tree;


/**
 * @author wxl
 * Date 2022/8/22 17:13
 * @version 1.0
 * Description: 树
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
    /**
     * Description: TODO
     * @author wxl
     * Date: 2023/3/6 13:28
     * @param val val
     * @param node node
     * @param address  address
     */
    TreeNode(int val, TreeNode node, boolean address) {
        this.val = val;
        if (address) {
            this.left = node;
        }else {
            this.right = node;
        }

    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}