package com.lark.algorithm.study.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2022-01-21 18:07
 * @Description TODO
 */
public class InsertionSort02 {

    public int[] doSort02(int[] arr) {
        int position = 0;
        for (int i = 1; i < arr.length; i++) {
            position = i;
            int curVal = arr[i];
            while (position > 0 && arr[position] < arr[position - 1]) {
                arr[position] = arr[position - 1];
                position--;
            }
            position = curVal;
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
