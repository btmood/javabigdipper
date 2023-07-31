package com.lark.algorithm.study.recursion;

/**
 * @author btmood
 * @date 2021-08-22 19:02
 * @Description TODO
 */
public class recursionDefine {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //计算arr(l...n)范围里的数字和
    private static int sum(int[] arr, int l) {
        //求解最基本问题
        if (l == arr.length) {
            return 0;
        }
        //把原问题转化为更小的问题
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }

}
