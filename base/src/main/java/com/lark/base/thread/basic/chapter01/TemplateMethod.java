package com.lark.base.thread.basic.chapter01;

/**
 * @author btmood
 * @date 2021-06-13 18:57
 * @Description TODO
 */
public class TemplateMethod {

    public final void print(String message) {
        System.out.println("###################");
        wrapPrint(message);
        System.out.println("###################");
    }

    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            public void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };
        t1.print("hello");
    }
}
