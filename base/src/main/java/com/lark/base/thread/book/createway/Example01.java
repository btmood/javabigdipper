package com.lark.base.thread.book.createway;

/**
 * @author btmood
 * @date 2022-03-24 21:20
 * @Description TODO
 */
public class Example01 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        while (true) {
            System.out.println("main方法执行中");
        }
    }

}

class MyThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("run方法执行中");
        }
    }
}
