package com.lark.algorithm.study.collection;

import com.lark.algorithm.study.linkedlist.LinkedList;

/**
 * @author btmood
 * @date 2021-08-29 20:00
 * @Description TODO
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList list;

    public LinkedListSet() {
        list = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
