package com.obeast.algorithm.string;

/**
 * @author wxl
 * Date 2023/2/27 14:08
 * @version 1.0
 * Description: 字符串替换
 */
public class ReplaceStr {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace2(s));
    }
    public static String replaceSpace1(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++){
            char charAt = chars[i];
            if (charAt == ' '){
                res.append("%20");
            }else {
                res.append(charAt);
            }
        }
        return res.toString();
    }
    public static String replaceSpace2(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }

}
