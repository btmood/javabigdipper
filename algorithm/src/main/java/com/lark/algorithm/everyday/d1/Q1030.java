package com.lark.algorithm.everyday.d1;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author btmood
 * @date 2021-09-18 16:04
 * @Description TODO
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1030 {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Map<Integer, String> map = new TreeMap<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int dis = Math.abs(row - rCenter) + Math.abs(col - cCenter);
                if (map.get(dis) == null) {
                    map.put(dis, row + "|" + col);
                } else {
                    map.put(dis, map.get(dis) + ";" + row + "|" + col);
                }
            }
        }
        int[][] res = new int[rows * cols][2];
        int index = 0;
        for (int key : map.keySet()) {
            String[] split = map.get(key).split(";");
            for (String s : split) {
                String[] nums = s.split("\\|");
                System.out.println(Arrays.toString(nums));
                res[index] = new int[]{Integer.valueOf(nums[0]), Integer.valueOf(nums[1])};
                index++;
            }
        }
        return res;
    }

    public int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int t = row * cols + col;
                res[t][0] = row;
                res[t][1] = col;
            }
        }
        Arrays.sort(res, (arr1, arr2) -> {
            int a1 = dist(arr1[0], arr1[1], rCenter, cCenter);
            int a2 = dist(arr2[0], arr2[1], rCenter, cCenter);
            return Integer.compare(a1, a2);
        });
        return res;
    }

    private int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public static void main(String[] args) {
        Q1030 q = new Q1030();
        int[][] ints = q.allCellsDistOrder2(80, 57, 19, 38);
        System.out.println(Arrays.deepToString(ints));
    }}
