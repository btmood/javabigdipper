package com.lark.algorithm.test.bst;

import com.lark.algorithm.array.Array;
import com.lark.algorithm.bst.BST;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author btmood
 * @date 2021-08-26 21:27
 * @Description TODO
 */
public class TestBst {
    
    @Test
    public void test01(){

        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.levelOrder();

//        bst.preOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();

//        System.out.println(bst);
        
    }
    
    @Test
    public void test02(){
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 5;

        //可能会存在重复元素，所以不一定有1000个元素
        for (int i = 0; i < n; i++) {
            int i1 = random.nextInt(10000);
            System.out.println(i1);
            bst.add(i1);
        }
        System.out.println("=================");

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            Integer integer = bst.removeMax();
            System.out.println(integer);
            nums.add(integer);
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                System.out.println("错误");
            }
        }
        System.out.println("成功");

    }
}
