package com.mars.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/28 18:18
 */
public class LeetCode1453 {

    private Integer max = 1;

    private List<Point> pointList;

    public int numPoints(int[][] darts, int r) {
        pointList = new ArrayList<>();
        Arrays.sort(darts, (v1, v2) -> v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0]);
        dfs(darts, r, pointList, 0);
        return max;
    }

    public void dfs(int[][] darts, int r, List<Point> pointList, int start) {
        for (int i = start; i < darts.length; i++) {
            int x = darts[i][0], y = darts[i][1];
            pointList.add(new Point(x, y));
            process(pointList, r);
            dfs(darts, r, pointList, i + 1);
            pointList.remove(pointList.size() - 1);
        }
    }

    public void process(List<Point> pointList, int r) {
        if (pointList.size() == 1) {
            return;
        }
        Point point = pointList.get(0);
        int x = point.getX(), y = point.getY();
        List<Point> coincidePoint = getAllPoints(x, y, r);
        int result = 1;
        for (int i = 1; i < pointList.size(); i++) {
            Point next = pointList.get(i);
            List<Point> allPointList = getAllPoints(next.getX(), next.getY(), r);
            coincidePoint = getCoincidePoint(coincidePoint, allPointList);
            if (coincidePoint.size() > 0) {
                result++;
                max = Math.max(result, max);
            }
        }

    }

    public List<Point> getAllPoints(int x, int y, int r) {
        List<Point> pointList = new ArrayList<>();
        for (int i = x - r; i <= x + r; i++) {
            for (int j = y - r; j <= y + r; j++) {
                if (isInCircle(Math.abs(i - x), Math.abs(j - y), r)) {
                    pointList.add(new Point(i, j));
                }
            }
        }
        return pointList;
    }

    public List<Point> getCoincidePoint(List<Point> coincidePoint, List<Point> allPoint) {
        List<Point> newPointList = new ArrayList<>();
        for (int i = 0; i < coincidePoint.size(); i++) {
            for (int j = 0; j < allPoint.size(); j++) {
                Point a = coincidePoint.get(i);
                Point b = allPoint.get(j);
                if (a.getX().equals(b.getX()) && a.getY().equals(b.getY())) {
                    newPointList.add(new Point(a.getX(), a.getY()));
                }
            }
        }
        return newPointList;
    }


    // 判定是否在圆中
    public boolean isInCircle(int x, int y, int r) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r;
    }

    public static void main(String[] args) {
        LeetCode1453 leetCode1453 = new LeetCode1453();
//        int[][] darts = {{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}};
        int[][] darts = {{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}};
//        int r = 5;
        int r = 2;
//        int result = leetCode1453.numPoints(darts, r);
//        System.out.println(result);


        for (int i = 0; i < darts.length; i++) {
            System.out.println(leetCode1453.getAllPoints(darts[i][0], darts[i][1], r));
        }
    }

}

@Data
@ToString
class Point {

    private Integer x;

    private Integer y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

}
