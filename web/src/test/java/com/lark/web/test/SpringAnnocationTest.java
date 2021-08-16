package com.lark.web.test;

import com.lark.web.WebApplication;
import com.lark.web.test.file.ICar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author btmood
 * @date 2021-08-13 16:12
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class SpringAnnocationTest {

    @Autowired
    @Qualifier("bmwCar")
    private ICar iCar;

    @Test
    public void test01(){
        iCar.drive();
    }



}
