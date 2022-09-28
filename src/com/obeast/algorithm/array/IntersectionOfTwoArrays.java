package com.obeast.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wxl
 * Date 2022/9/28 22:35
 * @version 1.0
 * Description:
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null ||
                nums1.length == 0 ||
                nums2 == null ||
                nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums1) {
            temp.add(i);
        }
        for (int i : nums2) {
            if (temp.contains(i)){
                res.add(i);
            }
        }
        return res.stream().mapToInt(x-> x).toArray();
    }
}
