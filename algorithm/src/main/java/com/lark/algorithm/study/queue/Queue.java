package com.lark.algorithm.study.queue;

/**
 * @author btmood
 * @date 2021-08-13 20:52
 * @Description TODO
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
