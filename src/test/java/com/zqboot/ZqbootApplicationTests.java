package com.zqboot;

import com.zqboot.common.RedisService;
import com.zqboot.constant.RedisConstant;
import com.zqboot.utils.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZqbootApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void redisadd() {
        boolean res = redisService.set(RedisConstant.TOKEN + "test", "123456");
        System.out.println(res);
        System.out.println(redisService.get(RedisConstant.TOKEN + "test"));
//        RedisService redisService = SpringUtils.getBeanByType(RedisService.class);
//        System.out.println(redisService);
    }

}
