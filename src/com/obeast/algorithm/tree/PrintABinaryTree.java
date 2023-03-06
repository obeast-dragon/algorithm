package com.obeast.algorithm.tree;

import java.util.*;

/**
 * @author wxl
 * Date 2023/3/5 9:53
 * @version 1.0
 * Description: 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class PrintABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.setLeft(new TreeNode(4));
        left.setRight(new TreeNode(5));
        root.setLeft(left);
        root.setRight(new TreeNode(3));
        System.out.println(Arrays.toString(levelOrder(root)));
    }



    /**
     * Description: dfs
     * @author wxl
     * Date: 2023/3/5 20:24
     * @param root  root
     * @return int[]
     */

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, 0, lists);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> list: lists) {
            result.addAll(list);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void dfs(TreeNode node, int level, List<List<Integer>> lists) {
        if (node == null) {
            return;
        }
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(node.val);
        dfs(node.left, level + 1, lists);
        dfs(node.right, level + 1, lists);
    }


    /**
     * Description: bfs
     * @author wxl
     * Date: 2023/3/5 20:25
     * @param root root
     * @return int[]
     */
    public static int[] levelOrder2(TreeNode root) {
        if (root == null) {return new int[0];}
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

}


