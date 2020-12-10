package xyz.dengjunbo.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.dengjunbo.chapter2.model.Customer;
import xyz.dengjunbo.chapter2.service.CustomerService;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CustomerServiceTest 单元测试
 */
public class CustomerServiceTest {
    private final CustomerService customerService;
    public CustomerServiceTest(){
        customerService = new CustomerService();
    }
    @Before
    public void init(){
        // TODO 初始化数据库
    }
    @Test
    public void getCustomerListTest()throws Exception{
        List<Customer>customerList = customerService.getCustomerList("");
        Assert.assertEquals(2,customerList.size());
    }
    @Test
    public void getCustomerTest()throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        System.out.println(customer.toString());
        Assert.assertNotNull(customer);
    }
    @Test
    public void createCustomerTest()throws Exception{
        Map<String,Object>fieldMap = new HashMap<>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","john");
        fieldMap.put("telephone","13512345678");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }
    @Test
    public void  updateCustomerTest()throws Exception{
        long id = 1;
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("contact","Eric");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }
    @Test
    public void deleteCustomerTest()throws Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
