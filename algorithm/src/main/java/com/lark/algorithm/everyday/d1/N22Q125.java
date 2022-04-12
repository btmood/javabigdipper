package com.lark.algorithm.everyday.d1;

import org.junit.Test;

/**
 * @author btmood
 * @date 2021-11-26 16:14
 * @Description Q125：验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N22Q125 {

    public boolean isPalindrome(String s) {
        String sFilter = "";
        for (int num : s.toCharArray()) {
            if ((num >= 48 && num <= 57) || (num >= 97 && num <= 122)) {
                sFilter += (char) num;
            }
            if (num >= 65 && num <= 90) {
                sFilter += (char) (num + 32);
            }
        }
        String left = "";
        String right = "";
        if (sFilter.length() % 2 == 0) {
            left = sFilter.substring(0, sFilter.length() / 2);
            right = sFilter.substring(sFilter.length() / 2, sFilter.length());
        } else {
            left = sFilter.substring(0, sFilter.length() / 2);
            right = sFilter.substring(sFilter.length() / 2 + 1, sFilter.length());
        }
        System.out.println(left);
        System.out.println(right);
        for (int i = 0; i < left.length(); i++) {
            System.out.println(left.charAt(i) + "|" + right.charAt(right.length() - 1 - i));
            if (left.charAt(i) != right.charAt(right.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder res = new StringBuilder();
        boolean isPure = false;
        for (int num : s.toCharArray()) {
            if ((num >= 48 && num <= 57) || (num >= 97 && num <= 122)) {
                res.append((char) num);
                isPure = true;
            }
            if (num >= 65 && num <= 90) {
                res.append((char) (num + 32));
                isPure = true;
            }
        }
        String sFilter = res.toString();
        if (!isPure) {
            return true;
        }
        if (sFilter.length() == 0) {
            return false;
        }
        System.out.println(sFilter);
        for (int i = 0; i <= sFilter.length() / 2; i++) {
            if (sFilter.charAt(i) != sFilter.charAt(sFilter.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    public boolean isPalindrome4(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public boolean isPalindrome5(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }



    @Test
    public void test01(){
        N22Q125 n22Q125 = new N22Q125();
        boolean palindrome = n22Q125.isPalindrome2("  ");
        System.out.println(palindrome);
        System.out.println("====================");
        n22Q125.isPalindrome("a");
    }

}
