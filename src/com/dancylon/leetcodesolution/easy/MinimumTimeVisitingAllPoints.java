package com.dancylon.leetcodesolution.easy;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        System.out.println("asdads".substring(1,1));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        if (points.length >=2) {
            int x1, x2, y1, y2,dx,dy;
            for (int i = 0; i < points.length - 1; i++) {
                x1 = points[i][0];
                y1 = points[i][1];
                x2 = points[i + 1][0];
                y2 = points[i + 1][1];

                dx = x2>=x1?x2-x1:x1-x2;
                dy = y2>=y1?y2-y1:y1-y2;
                sum += dx>=dy?dx:dy;
            }
        }
        return sum;
    }
}
