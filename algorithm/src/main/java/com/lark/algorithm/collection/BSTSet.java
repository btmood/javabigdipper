package com.lark.algorithm.collection;

import com.lark.algorithm.bst.BST;

/**
 * @author btmood
 * @date 2021-08-29 19:48
 * @Description 基于二分搜索树的Set集合实现
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    //我们自定义的bst中禁止添加重复元素
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
