package com.lark.algorithm.everyday.daily.date20220414;

import java.util.ArrayList;

/**
 * @author btmood
 * @date 2022-04-19 15:38
 * @Description Q821：字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * 示例 2：
 *
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 *  
 *
 * 提示：
 * 1 <= s.length <= 104
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D19Q821 {

    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                list.add(i);
            }
        }
        int[] answer = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            answer[i] = getMin(list, i);
        }
        return answer;
    }

    public int getMin(ArrayList<Integer> list, int index) {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            if (Math.abs(index - i) < min) {
                min = Math.abs(index - i);
            }
        }
        return min;
    }

    public int[] shortestToChar2(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        //假设c全部在左边的遍历
        for (int i = 0, left = -1; i < n; i++) {
            if (s.charAt(i) == c) {
                answer[i] = 0;
                left = i;
            } else {
                if (left == -1) {
                    answer[i] = n + 1;
                } else {
                    answer[i] = i - left;
                }
            }
        }
        //假设c全部在右边的遍历
        for (int i = n - 1, right = -1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right = i;
                answer[i] = 0;
            } else {
                //如果right不存在那么说明c肯定在左边，就不用处理了
                if (right != -1) {
                    answer[i] = Math.min(answer[i], right - i);
                }
            }
        }
        return answer;
    }
}
