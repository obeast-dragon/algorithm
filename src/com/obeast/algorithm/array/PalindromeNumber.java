package com.obeast.algorithm.array;

/**
 * @author wxl
 * Date 2022/9/28 9:35
 * @version 1.0
 * Description:
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int k = 292;
        System.out.println(isPalindrome(k));
    }



    public static boolean isPalindrome(int x) {
        /*
        剪枝：
        x < 0；
        x > 0,尾部为0
        * */
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int t = 0;
//        = 为偶数
//        < 为奇数
        while(t <= x) {
//            取x的尾部 + 之前的t然后进行赋值
            t = t * 10 + x % 10;
//            取完了之后 缩小
            x /= 10;
        }

        return x == t || x == t /10;
    }


    public static boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int t = 0;
        while (x > t) {
            t = t * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 t/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，t = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == t || x == t / 10;
    }

}
