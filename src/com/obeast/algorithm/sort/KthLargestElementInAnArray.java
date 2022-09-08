package com.obeast.algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author wxl
 * Date 2022/8/11 20:00
 * @version 1.0
 * Description: 215. 数组中的第K个最大元素
 */
public class KthLargestElementInAnArray {

    private static final Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest3(nums, k));

    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        assert heap.peek() != null;
        return heap.peek();
    }


    public static int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        int targetIndex = len - k;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            }
            else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            }else {
                right = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right){
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];

        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot){
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;

        }
        swap(nums, left, ge);
        return ge;
    }

    private static void swap(int[] nums, int v1, int  v2) {
        int temp;
        temp = nums[v1];
        nums[v1] = nums[v2];
        nums[v2] = temp;
    }
}
