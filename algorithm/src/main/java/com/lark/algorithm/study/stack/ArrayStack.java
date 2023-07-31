package com.lark.algorithm.study.stack;

import com.lark.algorithm.study.array.Array;

/**
 * @author btmood
 * @date 2021-07-20 22:28
 * @Description TODO
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 这里使用自定义的com.lark.algorithm.array.Array作为栈的底层数据结构
     */
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造
     * 虽然未初始化容量，但是自定义的数组初始化容量为10
     */
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
