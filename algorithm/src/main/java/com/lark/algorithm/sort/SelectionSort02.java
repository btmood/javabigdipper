package com.lark.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2022-01-20 20:53
 * @Description TODO
 */
public class SelectionSort02 {

    public int[] doSort01(int[] arr) {
        //最小值
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            //开始往后查找最小值
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //如果当前元素不是最小值，就swap一下
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    @Test
    public void test01(){
        int[] arr = new int[]{23,43,42,3,4,5,5,43,23,23,432};
        SelectionSort02 selectionSort02 = new SelectionSort02();
        System.out.println(Arrays.toString(selectionSort02.doSort01(arr)));;
    }
}
