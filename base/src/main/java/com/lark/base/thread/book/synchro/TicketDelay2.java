package com.lark.base.thread.book.synchro;

/**
 * @author btmood
 * @date 2022-03-27 9:19
 * @Description TODO
 * 对资源访问代码块添加了synchronized(lock)
 * lock即是锁，它必须唯一，也就是说只能被创建一次；它的类型是无所谓的。
 * 这是一个排他锁
 */
public class TicketDelay2 {

    public static void main(String[] args) {
//        SaleTicket2 saleTicket2 = new SaleTicket2();
//        new Thread(saleTicket2, "线程一").start();
//        new Thread(saleTicket2, "线程二").start();
//        new Thread(saleTicket2, "线程三").start();
//        new Thread(saleTicket2, "线程四").start();

        SaleTicket3 saleTicket3 = new SaleTicket3();
        new Thread(saleTicket3, "线程一").start();
        new Thread(saleTicket3, "线程二").start();
        new Thread(saleTicket3, "线程三").start();
        new Thread(saleTicket3, "线程四").start();
    }
}

class SaleTicket2 implements Runnable{

    private int tickets = 10;
    Object lock = new Object();


    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (tickets > 0){
                    System.out.println(Thread.currentThread().getName() + "卖出去的票" + "--------" + tickets--);
                } else {
                    break;
                }
            }
        }
    }
}

class SaleTicket3 implements Runnable{

    private int tickets = 10;


    @Override
    public void run() {
        while (true) {
            sale();
            if (tickets <= 0) {
                break;
            }
        }
    }

    /**
     * synchronized同样可以用于修饰方法，lock对象为this
     */
    private synchronized void sale() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出去的票" + "--------" + tickets--);
        }
    }
}
