package com.dancylon.leetcodesolution.easy;
public class DeepFraction {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,3,1,4,2,1};
        arr = fraction(arr);
        System.out.println(arr[0]+"/"+arr[1]);
    }
    private static int[] fraction(int[] cont){
        if(cont.length==1)
            return new int[]{cont[0],1};
        else
            return getResult(cont,cont.length-1,1,cont[cont.length-1]);
    }
    //递归转换分子分母
    private static int[] getResult(int[] cont,int index,int m,int d){
        m = cont[index-1]*d+m;
        if(index==1){
                return new int[]{m,d};
        }else{
            return getResult(cont,index-1,d,m);
        }
    }
}