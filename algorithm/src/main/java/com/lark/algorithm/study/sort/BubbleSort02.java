package com.lark.algorithm.study.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2022-01-20 19:48
 * @Description TODO
 */
public class BubbleSort02 {

    public int[] doSort01(int[] arr) {
        //这里当i=arr.length - 1,说明只有最后一个元素需要排序了，所以一个元素没有必要排序
        for (int i = 0; i < arr.length - 1; i++) {
            //最后一个元素不用排，可以通过倒数第二元素确定顺序， 减去i是因为有i个元素排好序了
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] doSort01_1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] doSort02(int[] arr) {
        boolean swap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
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

    public int[] doSort03(int[] arr) {
        boolean swap = false;
        int endPosition = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < endPosition; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                    endPosition = j;
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
        int[] arr = new int[]{23,43,42,3,4,5,5,43,23,23,432};
        BubbleSort02 bubbleSort02 = new BubbleSort02();
        System.out.println(Arrays.toString(bubbleSort02.doSort01(arr)));;
        System.out.println(Arrays.toString(bubbleSort02.doSort02(arr)));;
        System.out.println(Arrays.toString(bubbleSort02.doSort03(arr)));;
        System.out.println(Arrays.toString(bubbleSort02.doSort01_1(arr)));;
    }

}
