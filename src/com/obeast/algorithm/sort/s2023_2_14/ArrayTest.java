package com.obeast.algorithm.sort.s2023_2_14;

/**
 * @author wxl
 * Date 2023/2/14 22:55
 * @version 1.0
 * Description:
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 9, 2, 9, 9, 2};
        int[] b = {1, 1, 1, 1, 9, 2, 9, 9, 2, 2};
//        System.out.println(getOddNum(a));
        getOddNumTwo(b);
    }

    /**
     * Description: 在一个 任意偶数个相同的数和一个相同的奇数组成的数组中找到该奇数
     * a[] = [1,1,1,1,2,2,3,3,3]
     * res = 3
     *
     * @author wxl
     * Date: 2023/2/14 22:56
     */
    public static int getOddNum(int[] a) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res ^= a[i];
        }
        return res;
    }

    /**
     * Description: 在一个 任意偶数个相同的数和两个相同的奇数组成的数组中找到该奇数
     * a[] = [1,1,1,1,2,2,3,3,3]
     * res = 3
     *
     * @author wxl
     * Date: 2023/2/14 22:56
     */
    public static void getOddNumTwo(int[] a) {
//        假设两个数为 a 、 b
        int oddNum = getOddNum(a);  // => a ^ b

//        提取 oddNum 二进制 位 最右 为 1 的位
        int rightNum = oddNum & (~oddNum + 1);

        int aOrb = 0;
        for (int j : a) {
            if ((j & rightNum) == 1) {
                aOrb ^= j;
            }
        }
        System.out.println(aOrb + " : " + (oddNum ^ aOrb));
    }
}
