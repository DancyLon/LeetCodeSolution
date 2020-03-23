package com.dancylon.leetcodesolution.easy;

import com.dancylon.leetcodesolution.util.TreeNode;

import java.util.*;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 * */
public class TwoSum_IV {
    public static void main(String[] args) {

    }
    public static boolean result;
    public static boolean findTarget2(TreeNode root,int k) {
        Set<Integer> set = new HashSet<Integer>();
        searchTreeForSum(root,k,set);
        return result;
    }

    private static void searchTreeForSum(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return;
        }
        searchTreeForSum(root.left,k,set);
        searchTreeForSum(root.right,k,set);
        if (result || set.contains(k-root.val)) {
            result = true;
            return;
        }else
            set.add(root.val);
    }

    //遍历树，转换成数组的两数之和问题
    public static boolean findTarget1(TreeNode root,int k){
        if (root == null) {
            return false;
        }
        addAllIntFromTree(root);
        if (list == null || list.size() < 2) {
            return false;
        }
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(j < nums.length && i >= 0){
            if (nums[i] + nums[j] == k) {
                return true;
            } else if(nums[i] + nums[j] < k){
                if (i == j-1) {
                    return false;
                }else
                    i++;
            } else if (nums[i] + nums[j] > k) {
                if (j == i+1) {
                    return false;
                }else
                    j--;
            }
        }
        return false;
    }

    public static List<Integer> list = new ArrayList<Integer>();
    private static void addAllIntFromTree(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            addAllIntFromTree(root.left);
            addAllIntFromTree(root.right);
        }
    }
}
