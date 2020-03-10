package com.dancylon.leetcodesolution.easy;

import com.dancylon.leetcodesolution.util.TreeNode;
import java.util.*;

public class DiameterBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        n1.left.left = new TreeNode(4);
        n1.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(n1));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] arr = new int[1];
        searchTree(root,arr);
        return arr[0];
    }

    public static int searchTree(TreeNode node, int[] arr) {
        if (node.left == null && node.right == null) {
            return 1;
        }else {
            int leftDepth = 0;
            int rightDepth = 0;
            int depth = 0;
            if (node.left != null) {
                leftDepth = searchTree(node.left,arr);
            }
            if (node.right != null) {
                rightDepth = searchTree(node.right,arr);
            }
            depth = leftDepth + rightDepth;
            if (depth >= arr[0]) {
                arr[0] = depth;
            }
            return 1 + (leftDepth>rightDepth?leftDepth:rightDepth);
        }
    }

}
