package com.lark.algorithm.map;

/**
 * @author btmood
 * @date 2021-08-29 20:56
 * @Description TODO
 */
public interface Map<K, V> {

    void add(K ket, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();

}
