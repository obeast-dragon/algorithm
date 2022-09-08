package com.obeast.algorithm.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxl
 * Date 2022/8/13 12:20
 * @version 1.0
 * Description: 1. 两数之和
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int k = 9;
        int[] ints = twoSumMap(nums, k);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{ map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

