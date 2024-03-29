package com.lark.algorithm.everyday.d1;

/**
 * @author btmood
 * @date 2021-11-04 18:12
 * @Description Q35：搜索插入位置
 *              TAG:数组、二分
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 *
 * 输入: nums = [1], target = 0
 * 输出: 0
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N3Q35 {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        //特殊判断
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        //循环到最后的结果肯定是left==right，不管left还是right都是正确结果
        while (left < right) {
            //中间值不直接写成(left+right)/2，实我为了防止数值太大导致加法溢出
            int mid = left + (right - left) / 2;
            //target必须[只]大于等于前一个值才行
            if (nums[mid] < target) {
                //下次区间[mid+1, right]
                left = mid + 1;
            } else {
                //下次区间[left, mid]
                right = mid;
            }
        }
        return left;
    }

}
