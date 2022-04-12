package com.lark.base.thread.book.createway;

/**
 * @author btmood
 * @date 2022-03-24 21:33
 * @Description TODO
 */

/**
 * 线程分为前台线程和后台线程
 *  - 当只存在后台线程时，进程就会自动结束
 *  - 可以使用setDaemon()让一个线程变成后台线程，这个设置需要在启动线程之前进行
 *  观察下面的代码，可以看到所有线程都为后台线程后，进程就结束了
 */
public class BackendThread {
    public static void main(String[] args) {
        System.out.println("main线程是后台线程吗：" + Thread.currentThread().isDaemon());
        Dae dae = new Dae();
        Thread thread = new Thread(dae, "后台线程");
        System.out.println("thread线程默认是后台线程吗" + thread.isDaemon());
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class Dae implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "----------is running");
        }
    }
}
