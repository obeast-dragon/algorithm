package com.obeast.algorithm.sort;

import java.util.Random;

/**
 * @author wxl
 * Date 2022/8/11 20:41
 * @version 1.0
 * Description: 数组排序
 */
public class SortArray {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {


        int[] nums = {5,1,1,2,0,0};

        SortArray sortArray = new SortArray();
        for (int i : sortArray.sortArray(nums)) {
            System.out.println(i);
        }
    }


    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        quickSortThree(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSortThree(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //随机元素做哨兵
        int randomIndex = left + random.nextInt(right - left + 1);
        //把随机值放到第一个
        swap(nums, left, randomIndex);

//        //第一个元素做哨兵
        int pivot = nums[left];

        //第一个片区的索引   小于 [left + 1, firstArea)
        int firstArea = left + 1;

        //第二个片区留着原地即可   [firstArea, i)

        //第三个片区的索引  大于   [secondArea, right]
        int secondArea = right;

        //遍历指针
        int i = left + 1;

        while (i <= secondArea) {
            if (nums[i] < pivot){
                swap(nums, i, firstArea);
                firstArea++;
                i++;
            }
            else if (nums[i] == pivot) {
                i++;
            }
            else {
                //nums[i] > pivot
                swap(nums, i, secondArea);
                secondArea--;
            }
        }
        //最后  把哨兵的索引放到第二区间的前面一个元素
        swap(nums, left, firstArea - 1);

        //左区间
        quickSortThree(nums, left, firstArea - 2);
        //右区间
        quickSortThree(nums, secondArea + 1, right);
    }


//    public void quickSort(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        /*切点切分区间 返回第一个区间的尾部*/
//        int edgeFirst = partitionDouble(nums, left, right);
//        //左区间
//        quickSort(nums, left, edgeFirst - 1);
//        //右区间
//        quickSort(nums, edgeFirst + 1, right);
//    }
    private int partitionDouble(int[] nums, int left, int right) {

        //随机元素做哨兵
        int randomIndex = left + random.nextInt(right - left + 1);
        //把随机值放到第一个
        swap(nums, left, randomIndex);

//        //第一个元素做哨兵
        int pivot = nums[left];

        int smallLeftIndex = left + 1;
        int bigRightIndex = right;
        while (true){
            while (smallLeftIndex <= bigRightIndex && nums[smallLeftIndex] < pivot){
                smallLeftIndex++;
            }

            while (smallLeftIndex <= bigRightIndex && nums[bigRightIndex] > pivot){
                bigRightIndex--;
            }

            if (smallLeftIndex >= bigRightIndex){
                break;
            }
            swap(nums, smallLeftIndex, bigRightIndex);
            smallLeftIndex++;
            bigRightIndex--;
        }
        //移动哨兵
        swap(nums, left, bigRightIndex);

        //返回第一个区间的尾部
        return bigRightIndex;
    }

    private int partition(int[] nums, int left, int right) {

        //随机元素做哨兵
        int randomIndex = left + random.nextInt(right - left + 1);
        //把随机值放到第一个
        swap(nums, left, randomIndex);

//        //第一个元素做哨兵
        int pivot = nums[left];

//        //j在第一个区间代码
//        int j = left;
//        for (int i = left + 1; i <= right; i++){
//            if (nums[i] <= pivot){
//                j++;
//                swap(nums, i,  j);
//            }
//        }
//        swap(nums, left, j);
//
//        //返回第一个区间的尾部
//        return j;


        //j在第二个区间代码
        int j = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (pivot >= nums[i]) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, left, j - 1);

        //返回第一个区间的尾部
        return j - 1;
    }

    private void swap(int[] nums, int v1, int v2) {
        int temp;
        temp = nums[v1];
        nums[v1] = nums[v2];
        nums[v2] = temp;
    }

}
