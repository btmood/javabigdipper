package com.lark.algorithm.everyday;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author btmood
 * @date 2021-08-26 18:09
 * @Description TODO
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D6Q242 {

    public boolean isAnagram1(String s, String t) {
        return Arrays.stream(s.split("")).sorted().collect(Collectors.joining(""))
                .equals(Arrays.stream(t.split("")).sorted().collect(Collectors.joining("")))
                ? true : false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapArr = new int[128];
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        for (char c : c1) {
            mapArr[c]++;
        }
        for (char c : c2) {
            if (mapArr[c] == 0) {
                return false;
            } else {
                mapArr[c]--;
            }
        }
        return true;
    }

}
