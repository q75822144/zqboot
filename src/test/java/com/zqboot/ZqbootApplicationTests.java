package com.zqboot;

import com.zqboot.common.es.model.Customer;
import com.zqboot.common.es.service.CustomerRepository;
import com.zqboot.common.redis.RedisService;
import com.zqboot.common.redis.RedisTopic;
import com.zqboot.constant.RedisConstant;
import com.zqboot.utils.wxpay.WxPayDemo;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZqbootApplicationTests {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    Client client;

    @Autowired
    WxPayDemo wxPayDemo;

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
    public void redisPublish() {
        redisService.publishTopic(RedisTopic.HELLO.name(), "你好");
        redisService.publishTopic(RedisTopic.WORLD.name(), "世界");
    }

    @Test
    public void esAdd() {
        Customer c = customerRepository.save(new Customer("4", "mytest3", "呵呵"));
        System.out.println(c);
    }

    @Test
    public void esDelete() {
        customerRepository.delete("AWCceZj83MdQyYPEa_Tq");
    }

    @Test
    public void esUpdate() {
        Customer customer = new Customer("2", "zhangsan", "nihaoma");
        customerRepository.save(customer);
    }

    @Test
    public void esFind() {
        PageRequest pageRequest = new PageRequest(0, 10);
//        Page<Customer> customers = customerRepository.findByLastNameContaining("呵", pageRequest);
//        System.out.println(customers);
//        System.out.println(customers.getContent());

        PageRequest pageable = new PageRequest(0, 10);
        NativeSearchQueryBuilder nbq = new NativeSearchQueryBuilder().withIndices("customers").withTypes("customer")
                .withSearchType(SearchType.DEFAULT).withPageable(pageable);
        BoolQueryBuilder bqb = QueryBuilders.boolQuery();
        bqb.should(QueryBuilders.termQuery("name", "nihao"));
        bqb.filter(QueryBuilders.rangeQuery("id").gt("1"));
        Page<Customer> page = elasticsearchTemplate.queryForPage(nbq.withQuery(bqb).build(), Customer.class);
        System.out.println(page.getContent());
    }

    @Test
    public void testTemp() {
        System.out.println(elasticsearchTemplate);
        System.out.println(elasticsearchTemplate.getClient());
        System.out.println(client);
    }

    @Test
    public void testWxPay(){
        System.out.println(wxPayDemo.getAppID());
        System.out.println(wxPayDemo.getKey());
    }

}
