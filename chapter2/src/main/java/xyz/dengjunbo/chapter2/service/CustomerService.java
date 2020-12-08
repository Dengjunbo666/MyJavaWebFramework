package xyz.dengjunbo.chapter2.service;

import xyz.dengjunbo.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 提供客户服务数据
 **/
public class CustomerService {
    /**
    * 获取客户列表
    **/
    public List<Customer>getCustomerList(String keyword){
        //TODO
        return null;
    }

    /**
    * 获取客户
    */
    public Customer getCustomer(long id){
        //TODO
        return null;
    }
    /**
     *创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        //TODO
        return false;
    }
    /**
     * 更新用户
     */
    public boolean updateCustomer(long id,Map<String,Object>fieldMap){
        //TODO
        return false;
    }
    /**
     * 删除用户
     */
    public boolean deleteCustomer(long id){
        //TODO
        return false;
    }
}
