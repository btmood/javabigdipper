package com.lark.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2022-01-24 16:54
 * @Description TODO
 */
public class MergeSort02 {

    public int[] doSort01(int[] arr) {
        int[] t = new int[arr.length];
        doMergeSort(arr, t, 0, arr.length - 1);
        return arr;
    }

    public void doMergeSort(int[] arr, int[] t, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        doMergeSort(arr, t, left, middle);
        doMergeSort(arr, t,middle + 1, right);
        merge(arr, t, left, middle, right);
    }

    public void merge(int[] arr, int[] t, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (arr[i] > arr[j]) {
                t[k++] = arr[j++];
            } else {
                t[k++] = arr[i++];
            }
        }
        while (i <= middle) {
            t[k++] = arr[i++];
        }
        while (j <= right) {
            t[k++] = arr[j++];
        }
        System.out.println("K的长度：" + k);
        for (i = 0; i < k; i++) {
            arr[left + i] = t[i];
        }
    }

    @Test
    public void test01(){
        int[] arr = new int[]{23,43,42,3,4,5,5,43,23,23,432};
        MergeSort02 mergeSort02 = new MergeSort02();
        System.out.println(Arrays.toString(mergeSort02.doSort01(arr)));;
    }
}
