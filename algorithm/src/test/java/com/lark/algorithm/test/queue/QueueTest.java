package com.lark.algorithm.test.queue;

import com.lark.algorithm.queue.ArrayQueue;
import com.lark.algorithm.queue.LinkedListQueue;
import com.lark.algorithm.queue.LoopQueue;
import org.junit.Test;

/**
 * @author btmood
 * @date 2021-08-13 21:01
 * @Description TODO
 */
public class QueueTest {

    /**
     * 测试数组队列
     */
    @Test
    public void test01(){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 测试循环队列
     */
    @Test
    public void test02(){
        LoopQueue<Integer> queue = new LoopQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 测试链表队列
     */
    @Test
    public void test03(){
        LinkedListQueue<Integer> queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
