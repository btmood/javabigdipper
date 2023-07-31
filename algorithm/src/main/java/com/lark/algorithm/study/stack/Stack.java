package com.lark.algorithm.study.stack;

/**
 * @author btmood
 * @date 2021-07-20 22:27
 * @Description TODO
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
