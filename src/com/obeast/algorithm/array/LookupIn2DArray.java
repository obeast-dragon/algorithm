package com.obeast.algorithm.array;

/**
 * @author wxl
 * Date 2023/3/4 23:08
 * @version 1.0
 * Description: 剑指 Offer 04. 二维数组中的查找
 */
public class LookupIn2DArray {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,3,4},{1,2,3,4}};
        System.out.println(array.length);
        System.out.println(array[0].length);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rowIndex = matrix.length;
        if (rowIndex == 0) {
            return false;
        }
        int colIndex = matrix[0].length;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < colIndex; j++) {
                int num = matrix[i][j];
                if (target == num){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            int index = doubleSearch(nums, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }
    public int doubleSearch (int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }else if (num > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
