package com.lark.algorithm.everyday.d1;

/**
 * @author btmood
 * @date 2021-11-17 15:14
 * @Description Q283：移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明: [0.2.3.0.4.3]
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N13Q283 {

    //快慢指针
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[slow] != 0) {
                slow++;
                fast++;
            } else {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                    while (slow <= fast && nums[slow] != 0) {
                        slow++;
                    }
                }
                fast++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int count = 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
                count++;
            }
        }
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }

    public static void main(String[] args) {
        N13Q283 n13Q283 = new N13Q283();
        n13Q283.moveZeroes(new int[]{0,1,0,3,12});
    }
}
