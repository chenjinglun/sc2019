package com.xzsd.pc.customerquery.Controller;

import com.xzsd.pc.customerquery.Entity.CustomerEntity;
import com.xzsd.pc.customerquery.Service.CustomerService ;
import com.xzsd.pc.util.ResponceData ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customerQuery")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;
    /**
     *客户列表查询
     * @param customerEntity
     * author scout
     *2020年4月18日
     */
    @RequestMapping("queryCustomer")
    public ResponceData queryCustomer(CustomerEntity customerEntity) {
        try {
            return customerService.queryCustomer(customerEntity);
        } catch (Exception e) {
            logger.error("查询客户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
