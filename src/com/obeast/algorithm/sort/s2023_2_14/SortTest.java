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
        sortInsert(a);
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
        for (int i = 0; i < a.length; i++) {
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
}
