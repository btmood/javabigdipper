package com.lark.algorithm.study.sort;

/**
 * @author btmood
 * @date 2021-09-25 13:32
 * @Description 计数排序
 */
public class CountSort {

    /**
     * 算法步骤：
     * （1）找出原数组中元素值最大的，记为max
     * （2）创建一个新数组count，长度为max+1，值全部初始化为0
     * （3）遍历原数组，将原数组的元素作为索引，出现次数作为值插入到count数组中
     * （4）创建res结果数组，创建一个index变量维护res数组中的元素个数
     * （5）遍历count数组，内置while循环：【只要值大于0就往结果数组中插值】，直到遍历结束
     * @param arr
     * @return
     */
    public int[] doSort(int[] arr) {
        //找出数组中的最大值
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        //初始化计数数组count
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }
        //结果数组
        int[] res = new int[arr.length];
        //维护结果数组中元素的个数
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                res[index++] = i;
                count[i]--;
            }
        }
        return res;
    }

    /**
     * 思考上面的代码，会发现我们创建了多个临时空间用于存储数据，存在空间浪费问题，所以需要想办法优化一下
     * 1. count数组优化
     *  描述：
     *      上面直接使用数组中最大值作为数组长度，但是实际可能会造成大量空间浪费
     *      比如[101, 102, 103, 104, 105]，如果count数组初始化长度为105，那么count数组前面的0~100空间都浪费了
     *  解决：
     *      长度改为：max-min+1
     *
     * @param arr
     * @return
     */
    public int[] doSortOptimize(int[] arr) {
        //找出数组中的最大值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        //初始化计数数组count
        int[] count = new int[max - min + 1];
        for (int num : arr) {
            //num中的元素要减去最小值再插入count数组
            count[num - min]++;
        }
        //结果数组
        int[] res = new int[arr.length];
        //维护结果数组中元素的个数
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                //将减去的最小值补上
                res[index++] = i + min;
                count[i]--;
            }
        }
        return res;
    }

}
