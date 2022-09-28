package com.obeast.algorithm.array;

import java.util.Arrays;

/**
 * @author wxl
 * Date 2022/9/28 22:07
 * @version 1.0
 * Description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "rat";
        String s2 = "car";
        System.out.println(isAnagram2(s1, s2));
    }

    /**
     * Description: 排序法
     * @author wxl
     * Date: 2022/9/28 22:15
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }


    /**
     * Description: hash
     * @author wxl
     * Date: 2022/9/28 22:15
     * @param s
     * @param t
     * @return boolean
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] cache = new int[26];

        for (int i = 0; i < s.length(); i++){
            cache[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++){
            cache[t.charAt(i) - 'a']--;
            if (cache[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
