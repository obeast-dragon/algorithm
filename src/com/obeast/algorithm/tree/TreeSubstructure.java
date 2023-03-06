package com.obeast.algorithm.tree;

/**
 * @author wxl
 * Date 2023/3/6 10:26
 * @version 1.0
 * Description: 剑指 Offer 26. 树的子结构
 */
public class TreeSubstructure {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode right = new TreeNode(5);
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(isSubStructure(root, left));

    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        //遍历A节点，寻找与B节点相同的子节点
        if(A.val==B.val){
            if(match(A,B)){
                return true;
            }
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    /** 判断A节点是否包含B节点,递归 */
    public static boolean match(TreeNode A,TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null || A.val!=B.val){
            return false;
        }
        return match(A.left,B.left) && match(A.right,B.right);
    }

}
