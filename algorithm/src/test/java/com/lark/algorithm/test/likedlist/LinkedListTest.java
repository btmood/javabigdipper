package com.lark.algorithm.test.likedlist;

import com.lark.algorithm.linkedlist.LinkedList;
import org.junit.Test;

/**
 * @author btmood
 * @date 2021-08-14 15:32
 * @Description TODO
 */
public class LinkedListTest {
    
    @Test
    public void test01(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println(linkedList.getSize());
        linkedList.removeElement(2);
        System.out.println(linkedList);
        System.out.println(linkedList.getSize());
    }

}
