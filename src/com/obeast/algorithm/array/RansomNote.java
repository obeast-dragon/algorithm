package com.obeast.algorithm.array;

/**
 * @author wxl
 * Date 2022/9/28 23:34
 * @version 1.0
 * Description:
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RansomNote {
    public static void main(String[] args) {

    }

    /**
     * 可以构造
     *
     * @param ransomNote 赎金注意
     * @param magazine   杂志
     * @return boolean
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cache = new int[26];

        for (char c : magazine.toCharArray()) {
            cache[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            cache[c - 'a']--;
        }

        for (int i : cache) {
            if (i < 0){
                return false;
            }
        }
        return true;
    }
}
