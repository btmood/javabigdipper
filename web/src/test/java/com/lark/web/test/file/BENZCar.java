package com.lark.web.test.file;

import org.springframework.stereotype.Component;

/**
 * @author btmood
 * @date 2021-08-13 16:15
 * @Description TODO
 */
@Component
public class BENZCar implements ICar {
    @Override
    public void drive() {
        System.out.println("BENZ");
    }
}
