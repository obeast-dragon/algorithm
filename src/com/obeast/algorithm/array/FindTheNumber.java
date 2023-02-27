package com.obeast.algorithm.array;

/**
 * @author wxl
 * Date 2023/2/27 15:18
 * @version 1.0
 * Description:剑指 Offer 53 - I. 在排序数组中查找数字 I
 */

public class FindTheNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int k = 8;
        search(nums, 8);
    }


    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int mid = nums.length / 2;
        int searchLoop1 = searchLoopL(nums, mid, target);
        int searchLoop2 = searchLoopR(nums, mid, target);
        System.out.println(searchLoop1);
        System.out.println(searchLoop2);
        return searchLoop1 + searchLoop2;
    }

    private static int searchLoopL(int[] nums, int mid, int target) {
        int res = 0;
        for (int i = 0; i <= mid; i++) {
            if (nums[i] == target) {
                res++;
            }
        }
        return res;
    }

    private static int searchLoopR(int[] nums, int mid, int target) {
        int res = 0;
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            }
        }
        return res;
    }
}
