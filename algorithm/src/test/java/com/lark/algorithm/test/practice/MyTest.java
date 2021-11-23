package com.lark.algorithm.test.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2021-10-08 15:44
 * @Description TODO
 */
public class MyTest {

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {
        int temp = 0;
        boolean swap = false;
        for (int i = arr.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return arr;
    }


    @Test
    public void test01(){
        int[] arr = new int[]{3,534,2,54,65,657,2,3,66,66,7};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9};
//        MyTest.bubbleSort(arr);
        MyTest.bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }
    @Test
    public void test02(){
        System.out.println(1%3);
    }


}
