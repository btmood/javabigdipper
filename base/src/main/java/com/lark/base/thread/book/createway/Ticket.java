package com.lark.base.thread.book.createway;

/**
 * @author btmood
 * @date 2022-03-24 21:26
 * @Description TODO
 */
public class Ticket {

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        new Thread(ticketWindow, "n1").start();
        new Thread(ticketWindow, "n2").start();
        new Thread(ticketWindow, "n3").start();
        new Thread(ticketWindow, "n4").start();
        new Thread(ticketWindow, "n5").start();
    }
}

class TicketWindow implements Runnable{

    private int ticketNum = 100;


    @Override
    public void run() {
        while (ticketNum > 0) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "正在发售第" + ticketNum-- + "票");
            throw new RuntimeException("测试异常");
        }

    }
}
