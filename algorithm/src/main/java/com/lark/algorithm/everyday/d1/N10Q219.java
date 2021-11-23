package com.lark.algorithm.everyday.d1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author btmood
 * @date 2021-11-16 10:49
 * @Description Q219：存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N10Q219 {

    //哈希
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], i);
                continue;
            }
            if ((i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    //滑窗
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right - left > k) {
                left++;
            }
            for (int i = left; i < right; i++) {
                if (nums[i] == nums[right]) {
                    return true;
                }
            }
        }
        return false;
    }

    //滑窗优化
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
