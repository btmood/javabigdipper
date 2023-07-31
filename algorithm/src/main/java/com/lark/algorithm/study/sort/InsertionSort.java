package com.lark.algorithm.study.sort;

/**
 * @author btmood
 * @date 2021-09-24 20:07
 * @Description 插入排序
 */
public class InsertionSort<E extends Comparable<E>> {

    /**
     * 算法描述：
     * （1）把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的
     * （2）从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
     * （3）重复上述过程直到最后一个元素被插入有序子数组中。
     * 稳定性：
     *      由于只需要找到不大于当前数的位置而并不需要交换，因此，直接插入排序是稳定的排序方法。
     *      时间复杂度：
     *      O(n^2)，在数组元素较多时不适用，但是有少量数据时是个不错的选择，一般作为快排的扩充
     *      在JDK 7 java.util.Arrays所用的sort方法的实现中，当待排数组长度小于47时，会使用插入排序。
     *
     * @param arr
     * @return
     */
    public E[] doSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            E t = arr[i];
            int position = i;
            while (position > 0 && arr[position - 1].compareTo(t) > 0) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = t;
        }
        return arr;
    }
}
