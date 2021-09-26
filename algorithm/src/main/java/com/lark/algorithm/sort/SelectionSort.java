package com.lark.algorithm.sort;

/**
 * @author btmood
 * @date 2021-09-24 20:08
 * @Description 选择排序
 */
public class SelectionSort<E extends Comparable<E>> {

    /**
     * 算法描述：
     * （1）在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * （2）从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * （3）重复第二步，直到所有元素均排序完毕。
     * 时间复杂度：
     *      O(n^2)
     * 稳定性：
     *      这种排序是不稳定的，举个例子：[5,8,5,2,9]，第一次排序5和2会交换位置，那么两个相同的元素5位置发生改变，所以不稳定
     * @param arr
     * @return
     */
    public E[] doSort(E[] arr) {
        E t = null;
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            //查询最小值
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                t = arr[min];
                arr[min] = arr[i];
                arr[i] = t;
            }
        }
        return arr;
    }
}
