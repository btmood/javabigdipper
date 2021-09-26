package com.lark.algorithm.sort;

/**
 * @author btmood
 * @date 2021-09-25 10:54
 * @Description TODO
 */
public class QuickSort {

    /**
     * 算法步骤：
     * （1）任取一个元素为中心
     * （2）所有比它小的元素一律前放，比它大的元素一律后放，形成左右两个子表
     * （3）对各子表重新选择中心元素并依此规则调整
     * （4）直到每个子表的元素只剩一个
     * 关键：
     *      基准的位置以及上面的第二步
     *      可以创建一个变量记住基准数据，通过首尾指针与基准数据进行对比进行排序
     * 稳定性：
 *          不稳定
     *  时间复杂度：
 *          O(nlogn)
     * @param arr
     * @return
     */
    public int[] doSort(int[] arr) {
        doQuickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 递归快排
     * @param arr
     * @param low
     * @param high
     */
    public void doQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = position(arr, low, high);
            doQuickSort(arr, low, pivot - 1);
            doQuickSort(arr, pivot + 1, high);
        }
    }

    /**
     * 获取基准的索引
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int position(int[] arr, int low, int high) {
        //暂存基准数据
        int pivotValue = arr[low];
        while (low < high) {
            //当队尾元素大于等于基准数据时，向前移动high指针
            while (low < high && arr[high] >= pivotValue) {
                high--;
            }
            //当队尾元素小于基准数据时，需要将其复制给low指针
            //为什么不用进行if判断呢，因为进行到这一步是必然情况
            arr[low] = arr[high];
            //当队首元素小于等于基准数据时，向前移动low指针
            while (low < high && arr[low] < pivotValue) {
                low++;
            }
            //当队首元素大于基准数据时，将其复制给high指针
            arr[high] = arr[low];
        }
        //根据原理可知，当low==high时，这里的元素并不是基准数据，所以要将temp赋值给arr[low]
        arr[low] = pivotValue;
        //返回新的基准位置
        return low;
    }
}
