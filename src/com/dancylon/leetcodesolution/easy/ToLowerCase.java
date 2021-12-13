package com.dancylon.leetcodesolution.easy;
public class ToLowerCase {
    public static void main(String[] args) {

    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c:
             str.toCharArray()) {
            if (c <= 90 && c>=65) {
                c = (char)(c+32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
