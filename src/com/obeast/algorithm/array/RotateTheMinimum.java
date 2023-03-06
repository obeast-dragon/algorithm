package com.obeast.algorithm.array;

/**
 * @author wxl
 * Date 2023/3/5 0:37
 * @version 1.0
 * Description:剑指 Offer 11. 旋转数组的最小数字
 */
public class RotateTheMinimum {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {

        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] > numbers[high]){
                low = mid + 1;
            }else if (numbers[mid] < numbers[high]){
                high = mid;
            }else {
                high = high - 1;
            }
        }
        return numbers[low];
    }

}
