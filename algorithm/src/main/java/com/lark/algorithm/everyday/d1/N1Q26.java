package com.lark.algorithm.everyday.d1;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2021-10-08 17:30
 * @Description Q26：删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N1Q26 {

    public int removeDuplicates(int[] nums) {
        boolean same = false;
        for (int i = 0; i < nums.length; i++) {
            same = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    same = true;
                }
            }
            if (same) {
                if (i == nums.length - 1) {
                    if (same) {
                        return i;
                    } else {
                        return i + 1;
                    }
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != nums[i] && !preHas(i, j, nums)) {
                        nums[i] = nums[j];
                        break;
                    }
                    if (j == nums.length - 1) {
                        return i;
                    }
                }
            }
        }
        return nums.length;
    }

    private boolean preHas(int i, int j, int[] nums) {
        for (int m = 0; m < i; m++) {
            if (nums[m] == nums[j]) {
                return true;
            }
        }
        return false;
    }

    public  int removeDuplicates2(int[] nums) {
        int fast = 1;
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[fast] > nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        N1Q26 q26 = new N1Q26();
        int[] nums = new int[]{1,1,2};
//        int i = q26.removeDuplicates(nums);
////        System.out.println(i);
////        System.out.println(Arrays.toString(nums));

        int i = q26.removeDuplicates2(nums);
        System.out.println(i);
    }

}
