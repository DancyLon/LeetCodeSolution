package com.dancylon.leetcodesolution.easy;

import com.dancylon.leetcodesolution.util.TreeNode;

/**判断两个树是否相同*/
public class SameTress {
    public static void main(String[] args) {

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else {
            if (p == null && q != null) {
                return false;
            } else if (p !=null && q == null) {
                return false;
            } else {
                return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
        }
    }
}
