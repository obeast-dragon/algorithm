package com.obeast.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wxl
 * Date 2022/8/13 15:47
 * @version 1.0
 * Description:
 */

class Solution {
    public static int work(int[] nums, int time) {
        int dp = 0;
        int totalTime =(nums.length) * time;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 5 > 5){
                res++;
            }
        }
        if (res == nums.length){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % time == 0){
                continue;
            }else {
                dp++;
            }
        }
        return dp;
    }
}
public class Main
{
    public static void main(String[] args) {
//        Scanner sc1 = new Scanner(System.in);
//        Scanner sc2 = new Scanner(System.in);
//        String[] arg1 = sc1.nextLine().split(" ");
//        String[] arg2 = sc2.nextLine().split(" ");
//
//        int n = Integer.parseInt(arg1[0]);
//        int time = Integer.parseInt(arg1[1]);
//        int[] nums = new int[n];
//        for (int i = 0; i < arg2.length; i++) {
//            nums[i] = Integer.parseInt(arg2[i]);
//        }
        int time = 5;
        int[] nums = new int[]{8, 9, 10};
//        int[] nums = new int[]{100, 101, 102, 103, 104, 105};
        System.out.println(Solution.work(nums, time));
    }
}