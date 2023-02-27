package com.obeast.algorithm.array;

/**
 * @author wxl
 * Date 2023/2/27 15:46
 * @version 1.0
 * Description:剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3,4,5,6,7,8,9};
        missingNumber(nums);
//        int left = 0;
//        int right = nums.length ;
//        int mid = left + (right - left) >> 1;
//        System.out.println(mid);
    }

    public static int missingNumber(int[] nums) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            System.out.println(mid);
            if (mid == nums[mid]) left = mid + 1;
            else {
                res = mid;
                right = mid - 1;
            }
        }
        return res == -1 ? nums.length : res;
    }
}
