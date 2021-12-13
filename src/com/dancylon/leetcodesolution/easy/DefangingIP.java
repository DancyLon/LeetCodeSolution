package com.dancylon.leetcodesolution.easy;

public class DefangingIP {
    public static void main(String[] args) {
        String ip = "192.168.2.1";
        ip = ip.replaceAll("\\.","[\\.]");
        System.out.println(ip);
    }
    public static String defangIPaddr(String address) {
        char[] chs = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i]=='.')
                sb.append("[.]");
            else
                sb.append(chs[i]);
        }
        return sb.toString();
    }
}
