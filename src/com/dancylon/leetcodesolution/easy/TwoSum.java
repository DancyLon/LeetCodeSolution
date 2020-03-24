package com.dancylon.leetcodesolution.easy;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * */
public class TwoSum {
    public static void main(String[] args) {

    }
    public static int[] twoSum3(int[] nums,int target){
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] arr = new int[2048];
        int diff = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            index = arr[diff];
            if (index == 0) {
                arr[nums[i]] = i + 1;
            } else
                return new int[]{i,index -1};
        }
        return null;
    }

    public static int[] twoSum2(int[] nums,int target){
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            } else
                map.put(nums[i],i);
        }
        return null;
    }

    //现排序，然后用双指针
    public static int[] twoSum1(int[] nums, int target) {
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
