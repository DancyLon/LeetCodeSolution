package com.dancylon.leetcodesolution.easy;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * */
public class TwoSum_II {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    //双指针
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int i = 0;
        int j = numbers.length-1;
        while(j < numbers.length && i >= 0){
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i+1,j+1};
            } else if(numbers[i] + numbers[j] < target){
                if (i == j-1) {
                    return null;
                }else
                    i++;
            } else if (numbers[i] + numbers[j] > target) {
                if (j == i+1) {
                    return null;
                }else
                    j--;
            }
        }
        return null;
    }
}
