package com.lark.algorithm.test.stack;

import com.lark.algorithm.stack.ArrayStack;
import org.junit.Test;

/**
 * @author btmood
 * @date 2021-07-21 20:44
 * @Description TODO
 */
public class StackTest {

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
}
