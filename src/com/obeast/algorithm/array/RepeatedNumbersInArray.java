package com.obeast.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wxl
 * Date 2023/2/27 14:44
 * @version 1.0
 * Description:剑指 Offer 03. 数组中重复的数字
 */
public class RepeatedNumbersInArray {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

}
