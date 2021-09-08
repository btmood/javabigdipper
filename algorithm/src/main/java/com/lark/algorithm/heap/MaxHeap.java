package com.lark.algorithm.heap;

import com.lark.algorithm.array.Array;

/**
 * @author btmood
 * @date 2021-08-30 17:27
 * @Description 二叉最大堆——数组实现
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 将传入的数组转换为堆
     * heapify操作
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        /**
         * 从最后一个非叶子节点开始直到最大元素都进行完全的下沉操作
         * 如何找到最后一个非叶子节点？
         *  - 最后一个节点的父节点
         */
        for (int i = parent(arr.length - 1); i >= 0; i++) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn;t hava parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        //改变元素结构，使其满足最大堆的特性，孩子节点小于父节点
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮
     * 改变元素结构，使其满足最大堆的特性，孩子节点小于父节点
     * 只需要和父节点比较就行了
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax When heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax() {

        E ret = findMax();

        //将最大元素（数组第一个元素）与最小元素（数组最后一个元素）
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉
     * 如果父节点值小于孩子的值，那么就要把这个父节点下沉
     * 将父节点和两个孩子做比较，与值最大的孩子交换位置即可，循环直到比孩子都大，或者已经变成叶子节点为止
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            /**
             * 求出左右节点中的最大值
             * j为左孩子节点
             * （j + 1）即为有孩子节点，只要保证（j + 1 < data.getSize()）就说明完全二叉树中还有元素
             */
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            //将父节点与最大值进行比较
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            //如果父节点小于孩子最大值，那么就要交换连个位置的元素，然后再次进行下沉
            data.swap(k, j);
            //j为左右孩子中最大值的索引
            k = j;
        }
    }

    /**
     * 取出最大元素，并替换成元素e
     * 方案：替换数组第一个元素，并下沉
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
