package com.lark.algorithm.everyday.d1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author btmood
 * @date 2021-11-17 16:56
 * @Description Q349：两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N14Q349 {

    public int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for (Integer num : nums1) {
            map.put(num, 1);
        }
        for (Integer num : nums2) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        N14Q349 n14Q349 = new N14Q349();
        n14Q349.intersection1(new int[]{1,2,2,1}, new int[]{2,2});
    }
}
