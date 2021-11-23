package com.lark.algorithm.test.array;

import com.lark.algorithm.array.Array;
import com.lark.algorithm.array.ArrayInt;
import org.junit.Test;

/**
 * @author btmood
 * @date 2021-06-29 21:21
 * @Description TODO
 */
public class ArrayTest {
    
    @Test
    public void test01(){
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        //add()
        arr.add(1, 100);
        System.out.println(arr);

        //addFirst()
        arr.addFirst(-1);
        System.out.println(arr);

        //remove()
        arr.remove(2);
        System.out.println(arr);

        //removeElement()
        arr.removeElement(4);
        System.out.println(arr);

        //removeFirst()
        arr.removeFirst();
        System.out.println(arr);
    }

    @Test
    public void test02(){
        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addLast(100);
        System.out.println(arr);

        arr.addFirst(900);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.remove(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

    @Test
    public void test03(){
        ArrayInt arr = new ArrayInt(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        //add()
        arr.add(1, 100);
        System.out.println(arr);

        //addFirst()
        arr.addFirst(-1);
        System.out.println(arr);

        //remove()
        arr.remove(2);
        System.out.println(arr);

        //removeElement()
        arr.removeElement(4);
        System.out.println(arr);

        //removeFirst()
        arr.removeFirst();
        System.out.println(arr);
    }
}
