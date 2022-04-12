package com.lark.base.lambda.d01;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author btmood
 * @date 2022-01-18 10:43
 * @Description TODO
 */
public class TestLambda {

    @Test
    public void test01(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(01, 02);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test02(){
        TreeSet<Integer> ts = new TreeSet<>((x, y) -> Integer.compare(x, y));
    }

}
