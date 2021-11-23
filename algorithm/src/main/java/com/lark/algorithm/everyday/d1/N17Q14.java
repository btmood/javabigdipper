package com.lark.algorithm.everyday.d1;

/**
 * @author btmood
 * @date 2021-11-21 16:52
 * @Description Q14：最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N17Q14 {

    public String longestCommonPrefix(String[] strs) {
        String common = "";
        int index = 0;
        while (true) {
            if (strs[0].length() == index) {
                return common;
            }
            String judgeStr = String.valueOf(strs[0].charAt(index));
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == index || !String.valueOf(strs[i].charAt(index)).equals(judgeStr)) {
                    return common;
                }
            }
            common += judgeStr;
            index++;
        }
    }

    public String longestCommonPrefix2(String[] strs) {
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(common)) {
                if (common.length() == 0) {
                    return "";
                }
                common = common.substring(0, common.length() - 1);
            }
        }
        return common;
    }

    public static void main(String[] args) {
        N17Q14 n17Q14 = new N17Q14();
        String s = n17Q14.longestCommonPrefix(new String[]{"flower", "flag"});
        System.out.println(s);
    }
}
