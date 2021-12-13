package com.dancylon.leetcodesolution.easy;


public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        s = removeOuterParentheses1(s);
        System.out.println(s);
    }

    //My solution
    public static String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (char c: S.toCharArray()) {
            if (c == ')') {
                if (--p >= 1) {
                    sb.append(c);
                }
            }else{
                if (++p >= 2) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    //best solution
    public String removeOuterParentheses2(String S) {
        StringBuilder result=new StringBuilder();
        int level=0;
        for(char c:S.toCharArray()){
            if(c==')') level--;
            if(level>=1) result.append(c);
            if(c=='(') level++;
        }
        return result.toString();
    }
}
