package com.lark.base.thread.book.createway;

/**
 * @author btmood
 * @date 2022-03-24 21:21
 * @Description TODO
 */
public class Example02 {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println(111);
            }
        }).start();

        while (true) {
            System.out.println(222);
        }
    }
}
