package com.dancylon.leetcodesolution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {

    }
    //现排序，然后用双指针
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i:
             nums) {
            list.add(i);
        }
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length-1;
        while(j < nums.length && i >= 0){
            if (nums[i] + nums[j] == target) {
                return new int[]{list.indexOf(nums[i]),list.lastIndexOf(nums[j])};
            } else if(nums[i] + nums[j] < target){
                if (i == j-1) {
                    return null;
                }else
                    i++;
            } else if (nums[i] + nums[j] > target) {
                if (j == i+1) {
                    return null;
                }else
                    j--;
            }
        }
        return null;
    }
}
