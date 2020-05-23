package com.xzsd.pc.customerquery.Dao;

import com.xzsd.pc.customerquery.Entity.CustomerEntity ;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
/**
 * @ClassName DemoDao
 * @Description Demo
 * @Author scout
 * @Date 2020-04-18
 */
public interface CustomerDao {
    /**
     * 获取所有客户信息
     * @param customerEntity 客户信息
     * @return
     */
    List<CustomerEntity>queryCustomer(CustomerEntity customerEntity);
    /**
     * 根据角色获取当前店长客户
     * @param customerEntity
     * @return
     */
    List<CustomerEntity>listCustomerByRole(CustomerEntity customerEntity);

}