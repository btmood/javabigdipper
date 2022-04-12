package com.lark.algorithm.everyday.d1;

import java.math.BigInteger;

/**
 * @author btmood
 * @date 2021-11-24 10:45
 * @Description Q67：二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N21Q67 {

    public String addBinary(String a, String b) {
        String res = "";
        char[] longArr = null;
        char[] shortArr = null;
        if (a.length() > b.length()) {
            longArr = a.toCharArray();
            shortArr = b.toCharArray();
        } else {
            longArr = b.toCharArray();
            shortArr = a.toCharArray();
        }
        int step = 0;
        for (int i = longArr.length - 1; i >= 0; i--) {
            int m = Integer.valueOf(String.valueOf(longArr[i]));
            int n = 0;
            if (i - (longArr.length - shortArr.length) >= 0) {
                n = Integer.valueOf(String.valueOf(shortArr[i - (longArr.length - shortArr.length)]));
            }

            int mn = m + n;
            if (mn == 0) {
                res = (mn + step) + res;
                step = 0;
            } else if (mn == 1) {
                if (step == 0) {
                    res = mn + res;
                } else {
                    res = "0" + res;
                    step = 1;
                }
            } else if (mn == 2) {
                res = step + res;
                step = 1;
            }
        }
        if (step == 0) {
            return res;
        } else {
            return step + res;
        }
    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary3(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }

    public String addBinary4(String a, String b) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append((char) (sum % 2 + '0'));
            sum /= 2;
        }
        if (sum > 0) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        N21Q67 n21Q67 = new N21Q67();
        String s = n21Q67.addBinary4("1111", "1111");
        System.out.println(s);
    }


}
