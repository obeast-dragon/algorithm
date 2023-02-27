package com.obeast.algorithm.sort.s2023_2_14;

import java.util.Arrays;

/**
 * @author wxl
 * Date 2023/2/14 21:53
 * @version 1.0
 * Description:
 */

public class SortTest {
    public static void main(String[] args) {
        int[] a = {4, 2, 7, 3, 9, 0, 5};
        sortMerge(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Description: 选择排序
     * idea: 第一次通过递减遍历比较找到最小值  然后 第一个交换 以此类推
     * 数组前面减
     * 交换值：走完一遍交换
     *
     * @param a 数组
     * @author wxl
     * Date: 2023/2/14 22:04
     */
    public static void sortSelect(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
//        从 0->n-1 , 1->n-1 , 2->n-1 ... n-1
//        第一次层循环做左边界 ！！第二层循环做右边界

        for (int i = 0; i < a.length; i++) {
            // minIndex 必须 赋值 为i !!! 不能 从0   数组前面减
            int minIndex = i;
            // minIndex-n-1 中找到最小的值
            for (int j = i + 1; j < a.length; j++) {
                minIndex = a[minIndex] < a[j] ? minIndex : j;
            }
            //找到最小的值丢到最前面
            swapSelect(a, i, minIndex);
        }
    }

    private static void swapSelect(int[] a, int i, int minIndex) {
        int t = a[i];
        a[i] = a[minIndex];
        a[minIndex] = t;
    }


    /**
     * Description: 冒泡排序
     * 第一次通过左右进行比较 然后 然后会把最大值 移动到最后 以此类推
     * 数组后面减
     * 交换值：左右交换，不要走完才交换
     *
     * @author wxl
     * Date: 2023/2/14 22:10
     */
    public static void sortBubble(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
//        第一次层循环做左边界 ！！第二层循环做右边界
//        从0->n-1 中，左右比较把最大后移 ；0->n-2 .....
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swapBubble(a, j + 1, j);
                }
            }
        }
    }

    private static void swapBubble(int[] a, int i, int maxIndex) {
        a[i] = a[i] ^ a[maxIndex];
        a[maxIndex] = a[i] ^ a[maxIndex];
        a[i] = a[i] ^ a[maxIndex];
    }


    /**
     * Description: 插入排序
     * idea: 左右比较 小的往前移 ；如果 前面的 小于 后面的停止
     *
     * @author wxl
     * Date: 2023/2/14 23:55
     */
    public static void sortInsert(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
//        从0-1 =》 0-2 。。。。。 0 =》 n-1
//        注意 ：
//        第一次层循环做右边界 ！！第二层循环做左边界
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                swapInsert(a, j, j + 1);
            }
        }

    }

//    相同位置i,j相同位置会报错
    private static void swapInsert (int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }


    public static void sortMerge  (int[] a, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
//      左右区间递归通过 commonMerge 排序归并
        sortMerge(a, l, mid);
        sortMerge(a, mid + 1, r);
        commonMerge(a, l, mid, r);
    }

    private static void commonMerge(int[] a, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
//      help 的索引
        int i = 0;
//       第一个数组的 索引
        int p1 = l;
//       第二个数组的 索引
        int p2 = mid + 1;

//      当两个数组都没有越界
        while (p1 <= mid && p2 <= r){
//          给help数组赋值 i++
            help[i++] = a[p1] <= a[p2] ? a[p1++] : a[p2++];
        }
//        当 P2溢出
        while (p1 <= mid){
            help[i++] = a[p1++];
        }
        //  当 P1溢出

        while (p2 <= r){
            help[i++] = a[p2++];
        }
//       把help的值赋值到a[]的传入的区间中
        for (int j = 0; j < help.length; j++) {
            a[l + j] = help[j];
        }

    }
}
