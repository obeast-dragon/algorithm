package com.obeast.algorithm.array;

import java.util.Arrays;

/**
 * @author wxl
 * Date 2022/8/13 13:45
 * @version 1.0
 * Description: 88. 合并两个有序数组
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge1(nums1, m, nums2, n);

        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : nums2) {
            System.out.print(i + " ");
        }

    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
         while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


}
