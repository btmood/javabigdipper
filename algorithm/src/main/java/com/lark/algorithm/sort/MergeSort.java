package com.lark.algorithm.sort;

import java.util.Arrays;

/**
 * @author btmood
 * @date 2021-09-25 10:16
 * @Description 非泛型归并排序
 */
public class MergeSort {

    public int[] doSort(int[] arr) {
        int[] t = new int[arr.length];
        return doMergeSort(arr, t, 0, arr.length - 1);
    }

    /**
     * 递归排序
     * 算法步骤：
     * （1）创建一个临时数组，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * （2）设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * （3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * （4）重复步骤3直到某一指针到达序列尾
     * （5）将另一序列剩下的所有元素直接复制到合并序列尾
     * 时间复杂度：
     *      O(nlogn)
     * 稳定性：
     *      由于通过临时数组复制数据到原数组，所以是稳定的
     * @param arr
     * @param t
     * @param left
     * @param right
     * @return
     */
    private int[] doMergeSort(int[] arr, int[] t, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            doMergeSort(arr, t, left, middle);
            doMergeSort(arr, t, middle + 1, right);
            mergeArr(arr, t, left, middle, right);
        }
        return arr;
    }

    /**
     * 利用三个指针合并两个有序数组
     * 合并两个有序数组：典型的双指针解法
     * @param arr
     * @param t
     * @param left
     * @param middle
     * @param right
     */
    private void mergeArr(int[] arr, int[] t, int left, int middle, int right) {
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
        for (i = 0; i < k; i++) {
            arr[left + i] = t[i];
        }
    }
}
