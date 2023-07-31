package com.lark.algorithm.study.sort;

/**
 * @author btmood
 * @date 2021-09-25 13:32
 * @Description 希尔排序
 */
public class ShellSort {

    /**
     * 算法描述：
     * （1）选择一个增量gap，把数组分成含有n个元素的序列，比如这里gap = length / 2，
     *      那么增量序列就是{n/2,(n/2)/2,...,1}
     * （2）将数组按照增量划分成若干组，分组进行排序
     * （3）到最后增量变成1，就变成了一个普通的插入排序（但此时数组元素有序，插入排序效率高）
     * 增量：
     *      这里选择的增量并不是最优的，对于具体情况要选择增量，达到最好的效果
     * 时间复杂度：
     *      对于下面的希尔排序，最坏时间复杂度还是为O(n^2)
     *      但对于优化过增量的算法，比如Hibbard，最坏时间复杂度为O(n^3/2)
     * @param arr
     * @return
     */
    public int[] doSort(int[] arr) {
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            groupSort(arr, gap, length);
        }
        return arr;
    }

    public void groupSort(int[] arr, int gap, int length) {
        for (int i = gap; i < length; i += gap) {
            while (i >= gap && arr[i] < arr[i - gap]) {
                int temp = arr[i];
                arr[i] = arr[i - gap];
                arr[i - gap] = temp;
                i -= gap;
            }
        }
    }

}
