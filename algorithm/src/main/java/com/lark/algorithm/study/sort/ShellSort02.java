package com.lark.algorithm.study.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2022-01-24 15:11
 * @Description TODO
 */
public class ShellSort02 {

    public int[] doSort01(int[] arr) {
        //每次gap变为1/2大小
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tempIndex = i;
                //两两比较，进行交换
                //tempIndex作为右边的节点，与tempIndex - gap进行比较
               while (tempIndex - gap >= 0 && arr[tempIndex] < arr[tempIndex - gap]) {
                    int temp = arr[tempIndex];
                    arr[tempIndex] = arr[tempIndex - gap];
                    arr[tempIndex - gap] = temp;
                    tempIndex -= gap;
                }
            }
        }
        return arr;
    }


    public int[] doSort02(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tempIndex = i;
                while (tempIndex - gap >= 0 && arr[tempIndex] < arr[tempIndex - gap]) {
                    arr[tempIndex] = arr[tempIndex] + arr[tempIndex - gap];
                    arr[tempIndex - gap] = arr[tempIndex] - arr[tempIndex - gap];
                    arr[tempIndex] = arr[tempIndex] - arr[tempIndex - gap];
                    tempIndex -= gap;
                }
            }
        }
        return arr;
    }

    @Test
    public void test01(){
        int[] arr = new int[]{23,43,42,3,4,5,5,43,23,23,432};
        ShellSort02 shellSort02 = new ShellSort02();
        System.out.println(Arrays.toString(shellSort02.doSort01(arr)));;
        System.out.println(Arrays.toString(shellSort02.doSort02(arr)));;
    }
}
