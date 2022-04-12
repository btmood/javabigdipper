package com.lark.algorithm.everyday.d1;

import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * @author btmood
 * @date 2021-11-22 14:25
 * @Description Q58：最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N20Q58 {


    public int lengthOfLastWord(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] split = s.split(" ");
        for (String temp : split) {
            if (!"".equals(temp)) {
                list.add(temp.trim());
            }
        }
        return list.get(list.size() - 1).length();
    }

    public int lengthOfLastWord2(String s) {
        int empty = 0;
        int last = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                if (last > 0) {
                    return len - 1 - i - empty;
                } else {
                    empty++;
                }
            } else {
                last++;
            }
        }
        return len - empty;
    }

    public int lengthOfLastWord3(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

}
