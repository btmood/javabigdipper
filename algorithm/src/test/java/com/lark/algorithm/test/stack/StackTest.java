package com.lark.algorithm.test.stack;

import com.lark.algorithm.linkedlist.LinkedList;
import com.lark.algorithm.stack.ArrayStack;
import com.lark.algorithm.stack.LinkedListStack;
import org.junit.Test;

/**
 * @author btmood
 * @date 2021-07-21 20:44
 * @Description TODO
 */
public class StackTest {

    /**
     * 测试数组栈
     */
    @Test
    public void test01(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    /**
     * 测试链栈
     */
    @Test
    public void test02(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
