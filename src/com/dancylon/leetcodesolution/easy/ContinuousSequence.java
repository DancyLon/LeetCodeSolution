package com.dancylon.leetcodesolution.easy;

import java.util.*;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class ContinuousSequence {
    public static void main(String[] args) {
        int[][] arr = findContinuousSequence2(12314);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            System.out.println("==================");
        }
    }
    public static int[][] findContinuousSequence1(int target) {
        if (target <= 2) {
            return null;
        }else if (target == 3) {
            return new int[][]{{1,2}};
        }else if (target == 4) {
            return null;
        }else {
            double t = target*1.0;
            List list = new ArrayList();
            for (double i = 1,j = target/2; i < j && j<t;) {
                if ((i+j)*(j-i+1)*0.5==target) {
                    int[] arr = new int[(int) (j-i+1)];
                    for (int k = 0; k < j-i+1 ; k++) {
                        arr[k] = (int) (i+k);
                    }
                    list.add(arr);
                    i+=2;
                    j++;
                }else if((i+j)*(j-i+1)*0.5>target){
                    j--;
                }else if ((i+j)*(j-i+1)*0.5<target) {
                    i++;j++;
                }
            }
            if (list == null) {
                return null;
            }else{
                int[][] returnArr = new int[list.size()][];
                for (int i = 0; i < list.size(); i++) {
                    returnArr[i] = (int[]) list.get(i);
                }
                return returnArr;
            }
        }
    }

    //best
    public static int[][] findContinuousSequence2(int target) {
        //m项 首项为x 差为1 等差数列和为N, (x + x + m - 1)*m/2 = target
        //移项 (2x + m - 1)*m = 2*target
        //整理 x = (2 * target + m * (1 - m))/(2 * m) > 0, x为正整数
        List<int[]> res = new ArrayList<>();
        for (int m = 1; 2*target-m*m+m>0; m++) {
            int remainder = (2*target-m*m+m)%(2*m);
            if (remainder == 0 && m != 1) {//we r not adding the single target
                int[] arr = new int[m];
                arr[0] = (2 * target + m * (1 - m))/(2 * m);//递推填充
                for(int i = 1; i < m; i++) arr[i] = arr[i-1] + 1;
                res.add(0,arr);//头插逆序
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
