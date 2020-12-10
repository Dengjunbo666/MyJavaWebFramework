package xyz.dengjunbo.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.dengjunbo.chapter2.helper.DataBaseHelper;
import xyz.dengjunbo.chapter2.model.Customer;
import xyz.dengjunbo.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 提供客户服务数据
 **/
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
    * 获取客户列表
    **/
    public List<Customer>getCustomerList(String keyword){
        String sql = "SELECT * FROM CUSTOMER";
        return  DataBaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
    * 获取客户
    */
    public Customer getCustomer(long id){
        String sql = "SELECT * FROM CUSTOMER WHERE ID = "+id;
        return DataBaseHelper.queryEntity(Customer.class,sql);
    }
    /**
     *创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){

        return DataBaseHelper.insertEntity(Customer.class,fieldMap);
    }
    /**
     * 更新用户
     */
    public boolean updateCustomer(long id,Map<String,Object>fieldMap){
        return DataBaseHelper.updateEntity(Customer.class,id,fieldMap);
    }
    /**
     * 删除用户
     */
    public boolean deleteCustomer(long id){
        return DataBaseHelper.deleteEntity(Customer.class,id);
    }
}
