package com.lark.algorithm.study.array;

/**
 * @author btmood
 * @date 2021-06-29 20:55
 * @Description TODO
 */
public class ArrayInt {

    private int[] data;
    private int size;

    /**
     *
     * @param capacity 数组容量
     */
    public ArrayInt(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public ArrayInt() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末尾添加元素
     * @param e
     */
//    public void addLast(int e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("addLast() failed. Array is full");
//        }
//        data[size] = e;
//        size++;
//    }

    /**
     * 向数组末尾添加元素
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个元素
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add() failed. Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed. Require index >= 0 and index < size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get() failed. Require index >= 0 and index < size");
        }
        return data[index];
    }

    /**
     * 设置index位置元素为e
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set() failed. Require index >= 0 and index < size");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含元素
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove() failed. Require index >= 0 and index < size");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 删除数组中第一个元素
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除第一次出现的元素e
     * @param e
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        res.append(String.format("Array: size= %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
