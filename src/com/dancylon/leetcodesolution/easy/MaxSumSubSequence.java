package com.dancylon.leetcodesolution.easy;

/**
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * */
public class MaxSumSubSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = maxSubArr(arr);
        System.out.println("maxSum=" + maxSum);
    }

    private static int maxSubArr(int[] arr) {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < size; i++) {
            for (int i1 : arr) {
                
            }
        }
        return 0;
    }
}
