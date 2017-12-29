package com.zqboot.common.es.service;

/**
 * Created by Administrator on 2017/12/28.
 */

import com.zqboot.common.es.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastNameContaining(String lastName);

}