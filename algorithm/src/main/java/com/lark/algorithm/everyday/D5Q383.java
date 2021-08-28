package com.lark.algorithm.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author btmood
 * @date 2021-08-25 20:36
 * @Description TODO
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D5Q383 {

    public boolean canConstruct1(String ransomNote, String magazine) {
        for (char c : ransomNote.toCharArray()) {
            if (magazine.contains(String.valueOf(c))) {
                magazine = magazine.replaceFirst(String.valueOf(c), "");
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (Character c : ransomNote.toCharArray()) {
            if (frequency.get(c) != null) {
                if (frequency.get(c) > 1) {
                    frequency.put(c, frequency.get(c) - 1);
                } else {
                    frequency.remove(c);
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
