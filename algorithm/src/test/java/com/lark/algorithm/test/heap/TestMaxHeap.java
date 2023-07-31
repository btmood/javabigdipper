package com.lark.algorithm.test.heap;

import com.lark.algorithm.study.heap.MaxHeap;
import org.junit.Test;

import java.util.Random;

/**
 * @author btmood
 * @date 2021-08-30 19:00
 * @Description TODO
 */
public class TestMaxHeap {

    @Test
    public void test01(){
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");

    }
}
