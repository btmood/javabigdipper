package com.lark.algorithm.everyday.d1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author btmood
 * @date 2021-11-14 19:17
 * @Description Q136：只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N6Q136 {

    public int singleNumber(int[] nums) {
        outer: for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    continue outer;
                }
            }
            return nums[i];
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer s : map.keySet()) {
            if (map.get(s) == 1) {
                return s;
            }
        }
        return 0;
    }

    public int singleNumber3(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }
        return num;
    }

}
