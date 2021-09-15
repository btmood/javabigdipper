package com.lark.algorithm.everyday;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * @ClassName: D15Q447
 * @Description: TODO
 * @Author: zc
 * @Date: 2021-09-13 17:54
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D15Q447 {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> res = new HashMap();
            for (int j = i + 1; j < points.length; j++) {
                double distance = calcDistance(points[j], points[i]);
                res.put(distance, res.getOrDefault(distance, 0) + 1);
            }
            for (double key : res.keySet()) {
                int m = res.get(key);
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    private Double calcDistance(int[] point1, int[] point2) {
        return Math.pow(Math.abs(point2[0] - point2[0]), 2) + Math.pow(Math.abs(point2[1] - point2[1]), 2);
    }

    public static void main(String[] args) {
        D15Q447 d15Q447 = new D15Q447();
        int i = d15Q447.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}});
        System.out.println(i);
    }

}
