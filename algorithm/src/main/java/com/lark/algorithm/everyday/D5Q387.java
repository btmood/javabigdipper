package com.lark.algorithm.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author btmood
 * @date 2021-08-25 20:37
 * @Description TODO
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D5Q387 {

    public static int firstUniqChar(String s) {
        int res = -1;
        char[] chars = s.toCharArray();
        outer: for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) {
                    continue outer;
                }
            }
            res = i;
            break;
        }
        return res;
    }

    public static int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }
        int res = -1;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) != null && map.get(chars[i]) == i) {
                res = i;
                break;
            } else {
                map.remove(chars[i]);
            }
        }
        return res;
    }

}
