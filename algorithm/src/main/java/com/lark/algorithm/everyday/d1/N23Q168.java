package com.lark.algorithm.everyday.d1;

/**
 * @author btmood
 * @date 2021-11-27 13:44
 * @Description Q168：Excel表列名称
 *
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 *
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 *
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 *
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 *
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *  
 *
 * 提示：
 *
 * 1 <= columnNumber <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N23Q168 {

    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int mod = columnNumber % 26;
            res.append((char) (mod + 'A'));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }


}
