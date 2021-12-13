package com.dancylon.leetcodesolution.easy;

public class SplitStringBalancedStrings {
    public static void main(String[] args) {

    }
    public static int balancedStringSplit(String s) {
        int num = 0;
        if (s.length() >= 2) {
            int i = 0;
            char letter = s.charAt(0);
            for (char c:
                 s.toCharArray()) {
                if (letter == c) {
                    i++;
                }else{
                    i--;
                }
                if (i == 0) {
                    num++;
                }
            }
        }
        return num;
    }
}
