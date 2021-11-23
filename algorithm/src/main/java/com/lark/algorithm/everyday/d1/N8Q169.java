package com.lark.algorithm.everyday.d1;


import java.util.Stack;

/**
 * @author btmood
 * @date 2021-11-15 19:24
 * @Description Q169：多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N8Q169 {

    public int majorityElement1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (!stack.isEmpty() && stack.peek() != num) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        return stack.pop();
    }

    public int majorityElement2(int[] nums) {
        int count = 1;
        int now = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (count == 0) {
                now = nums[j];
                count++;
            } else {
                if (now != nums[j]) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return now;
    }

}
