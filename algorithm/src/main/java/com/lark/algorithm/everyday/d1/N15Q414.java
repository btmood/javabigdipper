package com.lark.algorithm.everyday.d1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author btmood
 * @date 2021-11-18 11:28
 * @Description Q414：第三大的数
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N15Q414 {

    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        if (list.size() < 3) {
            return list.get(list.size() - 1);
        }
        return list.get(list.size() - 3);
    }

    public int thirdMax2(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        if (treeSet.size() < 3) {
            return treeSet.last();
        }
        treeSet.pollLast();
        treeSet.pollLast();
        return treeSet.pollLast();
    }

    public int thirdMax3(int[] nums) {
        int[] array = IntStream.of(nums).distinct().sorted().toArray();
        return array[array.length < 3 ? array[array.length - 1] : array[array.length - 3]];
    }

    public int thirdMax4(int[] nums) {
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        long c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num > b && num < a) {
                c = b;
                b = num;
            } else if (num > c && b > num) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public static void main(String[] args) {
        N15Q414 n15Q414 = new N15Q414();
        int i = n15Q414.thirdMax1(new int[]{1, 2, 3});
        System.out.println(i);
    }
}
