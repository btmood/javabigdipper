package com.lark.algorithm.everyday.d1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2021-11-12 14:14
 * @Description Q88：合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N5Q88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while (m < nums1.length) {
            nums1[m++] = nums2[i++];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArr = new int[m + n];
        int a = 0;
        int b = 0;
        for (int i = 0; i < tempArr.length; i++) {
            if (a == m) {
                tempArr[i] = nums2[b++];
                continue;
            }
            if (b == n) {
                tempArr[i] = nums1[a++];
                continue;
            }
            if (nums1[a] < nums2[b]) {
                tempArr[i] = nums1[a++];
            } else {
                tempArr[i] = nums2[b++];
            }
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums1[i] = tempArr[i];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (a < 0) {
                nums1[i] = nums2[b--];
                continue;
            }
            if (b < 0) {
                nums1[i] = nums1[a--];
                continue;
            }
            if (nums1[a] > nums2[b]) {
                nums1[i] = nums1[a--];
            } else {
                nums1[i] = nums2[b--];
            }
        }
    }



    @Test
    public void test01(){
        N5Q88 n5Q88 = new N5Q88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        n5Q88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test02(){
        N5Q88 n5Q88 = new N5Q88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        n5Q88.merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
