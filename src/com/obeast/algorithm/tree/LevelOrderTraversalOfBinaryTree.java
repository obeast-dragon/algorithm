package com.obeast.algorithm.tree;

import com.obeast.algorithm.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wxl
 * Date 2022/8/22 17:12
 * @version 1.0
 * Description: 102. 二叉树的层序遍历
 */
public class LevelOrderTraversalOfBinaryTree {
    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        LevelOrderTraversalOfBinaryTree levelOrderTraversalOfBinaryTree = new LevelOrderTraversalOfBinaryTree();
        System.out.println(levelOrderTraversalOfBinaryTree.levelOrder(treeNode));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
//        recursion(root, 0);
        iterate(root);
        return res;
    }


    /**
     * Description: 迭代遍历
     * @author wxl
     * Date: 2022/8/23 10:30
     */
    public void iterate(TreeNode node){
        if (node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int len = queue.size();
            while (len > 0){
                TreeNode tempQueue = queue.poll();
                if (tempQueue != null) {
                    tempList.add(tempQueue.val);
                    if (tempQueue.left != null){
                        queue.offer(tempQueue.left);
                    }
                    if (tempQueue.right != null){
                        queue.offer(tempQueue.right);
                    }
                    len--;
                }
            }
            res.add(tempList);
        }

    }


    /**
     * Description: 递归层序遍历
     * @author wxl
     * Date: 2022/8/22 18:12
     */
    public void recursion(TreeNode node, Integer level) {
        if (node == null) {
            return;
        }
        //层数新增
        level++;
        if (res.size() < level){
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(node.val);
        recursion(node.left, level);
        recursion(node.right, level);
    }
}
