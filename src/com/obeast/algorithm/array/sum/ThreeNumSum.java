package com.obeast.algorithm.array.sum;

import java.util.*;

/**
 * @author wxl
 * Date 2022/8/22 9:55
 * @version 1.0
 * Description: 三数之和
 */
public class ThreeNumSum {
    public static void main(String[] args) {
//输出：[[-1,-1,2],[-1,0,1]]
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum2(nums));
    }

    /**
     * Description: Set去重Sort排序
     *
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author wxl
     * Date: 2022/8/22 10:13
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int fast = nums.length - 1;
            int slow = i + 1;
            while (slow < fast) {
                if (nums[i] + nums[fast] + nums[slow] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[fast], nums[slow])));
                    slow++;
                    fast--;
                } else if (nums[i] + nums[fast] + nums[slow] < 0) {
                    slow++;
                } else {
                    fast--;
                }
            }
        }
        return new ArrayList<>(res);
    }


    /**
     * Description: 两次手动去重
     * @author wxl
     * Date: 2022/8/22 14:04
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //剪枝全部都是正数的情况
            if(nums[i] > 0){
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int slow = i + 1;
            int fast = nums.length - 1;

            while (slow < fast){
                if (nums[i] + nums[slow] + nums[fast] == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[slow], nums[fast])));
                    slow++;

                    fast--;
                    //已经操作fast和slow了
                    while (slow < fast && nums[slow] == nums[slow - 1]) {
                        slow++;
                    }
                    while (slow < fast && nums[fast] == nums[fast + 1]) {
                        fast--;
                    }
                } else if (nums[i] + nums[slow] + nums[fast] < 0) {
                    slow++;
                }else {
                    fast--;
                }
            }
        }
        return res;
    }
}
