package com.lark.algorithm.everyday.d1;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2021-11-12 13:27
 * @Description TODO
 */
public class N4Q66 {

    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        long sum = 0;
        for (int i = 0; i < digits.length; i++) {
            long mul = (long) (digits[i] * Math.pow(10, len--));
            sum += mul;
        }
        sum++;
        String s = String.valueOf(sum);
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return res;
    }

    public int[] plusOne3(int[] digits) {
        boolean allNine = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    allNine = true;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (allNine) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] aa = new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,7};
        N4Q66 test1 = new N4Q66();
        int[] ints = test1.plusOne(aa);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne2(int[] digits) {
        int len = digits.length - 1;
        long sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i] * Math.pow(10, len--);
        }
        sum++;
        String s = String.valueOf(sum);
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return res;
    }
}
