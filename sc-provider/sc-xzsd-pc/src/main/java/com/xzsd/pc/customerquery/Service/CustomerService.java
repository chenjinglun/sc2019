package com.xzsd.pc.customerquery.Service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customerquery.Dao.CustomerDao;
import com.xzsd.pc.customerquery.Entity.CustomerEntity;
import com.xzsd.pc.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    /**
     * demo 查询客户列表（分页）
     * @param customerEntity
     * @return
     * @Author scout
     * @Date 2020-4-18
     */
    public ResponceData queryCustomer(CustomerEntity customerEntity) {
        PageHelper.startPage(customerEntity.getPageNum(), customerEntity.getPageSize());
        List<CustomerEntity> customerList;
        // 包装Page对象
        if(customerEntity.getRole()==2){
            customerEntity.setUserCode(SecurityUtils.getCurrentUserId());
            customerList = customerDao.listCustomerByRole(customerEntity);
        }
        else if(customerEntity.getRole() == 1){
            customerList = customerDao.queryCustomer(customerEntity);
        }
        else{
            return ResponceData.success("无权访问");
        }
        PageInfo<CustomerEntity> pageData = new PageInfo<>(customerList);
        return ResponceData.success("查询成功！",pageData);
    }
}

