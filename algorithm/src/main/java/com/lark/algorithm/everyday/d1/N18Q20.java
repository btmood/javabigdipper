package com.lark.algorithm.everyday.d1;


import java.util.Stack;

/**
 * @author btmood
 * @date 2021-11-22 13:22
 * @Description Q20：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N18Q20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if (stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if (stack.peek() == '{' && c == '}') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        boolean hasValid = true;
        while (hasValid) {
            hasValid = false;
            if (s.indexOf("()") != -1) {
                s = s.replace("()", "");
                hasValid = true;
            }
            if (s.indexOf("[]") != -1) {
                s = s.replace("[]", "");
                hasValid = true;
            }
            if (s.indexOf("{}") != -1) {
                s = s.replace("{}", "");
                hasValid = true;
            }
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        N18Q20 n18Q20 = new N18Q20();
        boolean valid2 = n18Q20.isValid2("([{}])}");
        System.out.println(valid2);
    }
}
