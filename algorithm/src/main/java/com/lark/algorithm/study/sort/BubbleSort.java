package com.lark.algorithm.study.sort;

/**
 * @author btmood
 * @date 2021-09-24 20:06
 * @Description 冒泡排序
 */
public class BubbleSort<E extends Comparable<E>> {

    /**
     * 一共比较次数为(n-1) + (n-2) + (n-3) + … + 1 = n * (n-1) / 2;
     * 所以时间复杂度：O(n^2)
     * 由于重复的元素并不会交换位置，所以这种排序是稳定的
     * @param arr
     * @return
     */
    public E[] doSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            /**
             * 为什么小于arr.length - 1 - i呢？
             * 因为i代表排序的次数，排了多少次，就有多少个数字到了数组最后，那些拍好的数就不用再操作了
             */
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    E t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }

    /**
     * 在数据完全有序的情况下，冒泡排序时间复杂度为O(n)
     * 所以我们添加一个swap标志，只要本轮没有交换，那么说明数据以及有序，不需要再进行下一轮循环了
     * 另外，我们这边是从后往前遍历，就不需要考虑（arr.length - 1 - i）这种范围了
     * @param arr
     * @return
     */
    public E[] doSortOptimize(E[] arr) {
        E t = null;
        boolean swap = false;
        for (int i = arr.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return arr;
    }
}
