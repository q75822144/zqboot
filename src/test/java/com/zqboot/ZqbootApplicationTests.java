package com.zqboot;

import com.zqboot.common.es.model.Customer;
import com.zqboot.common.es.service.CustomerRepository;
import com.zqboot.common.redis.RedisService;
import com.zqboot.constant.RedisConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZqbootApplicationTests {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CustomerRepository customerRepository;

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

    @Test
    public void esAdd(){
        customerRepository.save(new Customer("3","mytest2","hehenihao2"));
        List<Customer> customers = customerRepository.findByLastNameContaining("hehenihao");
        System.out.println(customers.get(0).getFirstName());
    }

    @Test
    public void esDelete(){
        customerRepository.delete("AWCceZj83MdQyYPEa_Tq");
    }

    @Test
    public void esUpdate(){
        Customer customer = new Customer("2","zhangsan","nihaoma");
        customerRepository.save(customer);
    }

    @Test
    public void  esFind(){
        List<Customer> customers = customerRepository.findByLastNameContaining("nihao");
        System.out.println(customers.size());
    }

}
