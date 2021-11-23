package com.lark.algorithm.test;

import org.junit.Test;

/**
 * @author btmood
 * @date 2021-11-04 18:39
 * @Description TODO
 */
public class TestAll {


    @Test
    public void test01(){
        System.out.println(10 / 2);
        System.out.println(10 % 2);
        System.out.println(9 / 2);
        System.out.println(9 % 2);
    }

    @Test
    public void test02(){
        int len = 1;
        int a = len;
        len = 4;
        System.out.println(len + "|" + a);
    }

    @Test
    public void test03(){
        int a = 187;
        System.out.println(~(a - 1));
    }

}
