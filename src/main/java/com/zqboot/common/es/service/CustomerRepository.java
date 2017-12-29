package com.zqboot.common.es.service;

/**
 * Created by Administrator on 2017/12/28.
 */

import com.zqboot.common.es.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public Page<Customer> findByLastNameContaining(String lastName, Pageable pageable);

}