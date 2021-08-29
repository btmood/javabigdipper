package com.lark.algorithm.collection;

/**
 * @author btmood
 * @date 2021-08-29 19:47
 * @Description TODO
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
