package com.lark.algorithm.everyday.d1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2021-12-29 9:35
 * @Description Q242:有效的字母异位词
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
public class N26Q242 {

    /**
     * s = "aa"
     * t = "bb"
     * 上面的case会报错
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramWrong1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int xor = 0;
        for (int i = 0; i < sChar.length; i++) {
            xor ^= sChar[i] ^ tChar[i];
        }
        return xor == 0;
    }

    /**
     * wrong1版本的修改
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int xorS = 0;
        int xorT = 0;
        for (int i = 0; i < sChar.length; i++) {
            xorS ^= sChar[i];
            xorT ^= tChar[i];
        }
        if (xorS == 0 && xorT == 0 && s.charAt(0) == t.charAt(0)) {
            return true;
        }
        if ((xorS ^ xorT) == 0) {
            return true;
        }
        return false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int [] sArr = new int[123];
        int [] tArr = new int[123];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)] ++;
            tArr[t.charAt(i)] ++;
        }
        for (int i = 0; i < 123; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] mapChar =  new int[128];
        for (char c : sChar) {
            mapChar[c]++;
        }
        for (char c : tChar) {
            if (mapChar[c] == 0) {
                return false;
            } else {
                mapChar[c]--;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mapChar[s.charAt(i)]++;
            mapChar[t.charAt(i)]--;
        }
        return Arrays.stream(mapChar).allMatch(e -> e == 0);
    }

    @Test
    public void test01(){
        char c1 = 'a';
        char c2 = 'a';
        System.out.println(c1 ^ c2);

    }
}
