package com.ayg.tools.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AppTest{
    static Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void testApp(){
        System.out.println("开始进行测试");
        try {
            //调用业务线程
            test2("参数传递");
            logger.info("进行休眠1000ms");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.warn("测试成功");
    }

    public void test2(String who){
        logger.info("测试需要传递参数的方法");
        logger.info("");
    }
}
