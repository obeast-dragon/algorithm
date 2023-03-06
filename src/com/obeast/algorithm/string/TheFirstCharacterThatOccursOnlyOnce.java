package com.obeast.algorithm.string;

import java.util.HashMap;

/**
 * @author wxl
 * Date 2023/3/5 0:48
 * @version 1.0
 * Description:剑指 Offer 50. 第一个只出现一次的字符
 */
public class TheFirstCharacterThatOccursOnlyOnce {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars) {
            if (map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}
