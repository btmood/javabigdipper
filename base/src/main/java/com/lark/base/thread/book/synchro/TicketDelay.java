package com.lark.base.thread.book.synchro;

/**
 * @author btmood
 * @date 2022-03-27 9:09
 * @Description TODO
 * 由于在访问资源时线程进行了休眠，所以其它线程错误的访问资源，导致能卖出-1张票
 */
public class TicketDelay {

    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        new Thread(saleThread, "线程一").start();
        new Thread(saleThread, "线程二").start();
        new Thread(saleThread, "线程三").start();
        new Thread(saleThread, "线程四").start();
    }


}


class SaleThread implements Runnable {
    private int tickets = 10;
    @Override
    public void run() {
        while (tickets > 0) {
            try {
                //线程睡眠没能及时减票，之后的线程又会进入这个代码块中
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出去的票" + "--------" + tickets--);
        }

    }
}
