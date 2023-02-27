package com.obeast.algorithm.string;

/**
 * @author wxl
 * Date 2023/2/27 14:33
 * @version 1.0
 * Description:剑指 Offer 58 - II. 左旋转字符串
 */
public class LeftRotateString {
    public static void main(String[] args) {
       String s = "abcdefg";
       int k = 2;
        System.out.println(reverseLeftWords(s, k));
    }

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == n) {
                String before = s.substring(0, i + 1);
                String after = s.substring(i + 1,  chars.length);
                sb.append(after);
                sb.append(before);
            }
        }
        return sb.toString();
    }

}
