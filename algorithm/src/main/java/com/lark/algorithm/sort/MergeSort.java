package com.lark.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author btmood
 * @date 2021-09-24 20:07
 * @Description 归并排序
 */
public class MergeSort<E extends Comparable<E>> {

    public E[] doSort(E[] arr) {
        List<E> t = new ArrayList<>(arr.length);
//        E[] t = (E[]) new Object[arr.length];
        return doMergeSort(arr, t, 0, arr.length - 1);
    }

    private E[] doMergeSort(E[] arr, List<E> t, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            doMergeSort(arr, t, left, middle);
            doMergeSort(arr, t, middle + 1, right);
            mergeArr(arr, t, left, middle, right);
        }
        return arr;
    }

    private void mergeArr(E[] arr, List<E> t, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (arr[i].compareTo(arr[j]) > 0) {
                t.add(k++, arr[j++]);
            } else {
                t.add(k++, arr[i++]);
            }
        }
        while (i <= middle) {
            t.set(k++, arr[i++]);
        }
        System.out.println("i = " + i);
        while (j <= right) {
            t.set(k++, arr[j++]);
        }
        System.out.println("j = " + j);
        for (i = 0; i < k; i++) {
            arr[left + i] = t.get(i);
        }
    }

}
