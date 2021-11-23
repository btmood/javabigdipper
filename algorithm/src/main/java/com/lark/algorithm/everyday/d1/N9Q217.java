package com.lark.algorithm.everyday.d1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author btmood
 * @date 2021-11-16 9:35
 * @Description Q217：存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N9Q217 {

    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            }
            map.put(num, num);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i= 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

}
