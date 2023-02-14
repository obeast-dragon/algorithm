package com.obeast.algorithm.string;

/**
 * @author wxl
 * Date 2022/9/29 8:48
 * @version 1.0
 * Description:
 * 344. Reverse String
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseString {
    public static void main(String[] args) {

    }
    public void reverseString(char[] s) {
        int a = 0;
        int b = s.length - 1;
        while (a < b) {
            s[a] ^= s[b];  //构造 a ^ b 的结果，并放在 a 中
            s[b] ^= s[a];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[a] ^= s[b];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            a++;
            b--;
        }

    }
}
