package com.dancylon.leetcodesolution.medium;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(arr);
        for (List<Integer> ll:
             list) {
          System.out.println(Arrays.toString(ll.toArray(new Integer[ll.size()])));
        }
    }

    /*
     * 思路类似两数之和，用0减去两个数，得到第三个数，
     * 然后检测数组中是否包含第三个数
     * 为了去重，我们要记录这两个树的乘积，
     * 两组树的乘积不同，我们就认为他们是不同的
     *
     * 比如
     * a+b+c=0
     * e+f+c=0
     * a+b = e+f
     * 但是 ab!=ef
     * 我们把所有数放在map中作为key
     * value是一个 Long型的List
     * 该list的第一个元素是这个数在原数组中的索引值，
     * 如果原数组中有重复元素，那就是最后一个索引值。
     * 然后每出现一对组合，我们就把这两个数的乘积放入List中，
     * 同时将这三个数另外两种组合也放入他们对应的数的list中
     * 比如
     *
     * a+b+c=0 e+f+c=0 i+j+c=0
     * 上面这三种组合都与c有关
     * 当检索到 a b时
     * 得到 c = 0 - a - b
     * 此时我们去找 list = map.get(c)
     * 首先确定c的索引和a、b都不一样
     * 然后看list中是否包含a*b
     * 如果没有，那[a,b,c],就是我们要找的组合
     * 然后把a*b放入list中
     * 然后把a*c放入b的list中，b*c放入a的list中
     * 这样就避免了重复
     *
     * 当检索到 e f 时，同样得到 c = 0 - e - f
     * 然后得到 list = map.get(c)
     * 这时list中有两个数[c的索引,a*b]
     * 由于 e*f 是肯定不等于 a*b的
     * 所以 [e,f,c]又是一个有效的组合
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Map<Integer,List<Long>> map = new HashMap<Integer,List<Long>>();
        for (int i = 0; i < nums.length; i++) {
            List<Long> list = new ArrayList<Long>();
            list.add((long)i);
            map.put(nums[i],list);
        }
        List<List<Integer>> list  = new ArrayList<List<Integer>>();
        int diff = 0;
        long index = 0;
        List<Long> llist;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                diff = 0 - nums[i] - nums[j];
                if (map.containsKey(diff) ) {
                    llist = map.get(diff);
                    index = llist.get(0);
                    if (index != i && index != j) {
                        if (llist.lastIndexOf((long)nums[i]*(long)nums[j]) <= 0) {
                            List<Integer> ll = new ArrayList<Integer>();
                            ll.add(nums[i]);
                            ll.add(nums[j]);
                            ll.add(diff);
                            list.add(ll);
                            llist.add((long)nums[i] * (long)nums[j]);

                            map.get(nums[i]).add((long)diff*(long)nums[j]);
                            map.get(nums[j]).add((long)diff*(long)nums[i]);
                        }
                    }
                }
            }
        }
        return list;
    }
}
