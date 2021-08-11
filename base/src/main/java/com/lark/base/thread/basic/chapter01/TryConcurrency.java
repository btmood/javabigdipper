package com.lark.base.thread.basic.chapter01;

/**
 * @author btmood
 * @date 2021-06-13 16:49
 * @Description TODO
 */
public class TryConcurrency {

    public static void main(String[] args) {
//        readFromDateBase();
//        writeToFile();

//        try {
//            Thread.sleep(1000 * 40);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println("Task1 =>" + i);
//            }
//        }).start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println("Task2 =>" + i);
//            }
//        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            readFromDateBase();
        }, "Read-Thread").start();

        new Thread(() -> {
            writeToFile();
        }, "Write-Thread").start();
    }

    public static void readFromDateBase() {
        try {
            System.out.println("begin read date from DB.");
            Thread.sleep(1000 * 10 );
            System.out.println("read from DB end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile() {
        try {
            System.out.println("begin write date to file.");
            Thread.sleep(1000 * 20);
            System.out.println("write date to file end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
