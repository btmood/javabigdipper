package com.lark.algorithm.everyday.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author btmood
 * @date 2021-08-20 17:01
 * @Description TODO
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D3Q350 {

    public int[] intersect1(int[] nums1, int[] nums2) {
        int[] longArr = null;
        int[] shortArr = null;
        if (nums1.length > nums2.length) {
            longArr = nums1;
            shortArr = nums2;
        } else {
            shortArr = nums1;
            longArr = nums2;
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < longArr.length; i++) {
            for (int j = 0; j < shortArr.length; j++) {
                if (longArr[i] == shortArr[j] && !indexList.contains(j)) {
                    indexList.add(j);
                    break;
                }
            }
        }
        int[] res = new int[indexList.size()];
        for (int i = 0; i < indexList.size(); i++) {
            res[i] = shortArr[indexList.get(i)];
        }
        return res;
    }

}
