package xyz.dengjunbo.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.dengjunbo.chapter2.model.Customer;
import xyz.dengjunbo.chapter2.service.CustomerService;

import java.util.List;

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
    public void getCustomerListTest(){
        List<Customer>customerList = customerService.getCustomerList("");
        Assert.assertEquals(2,customerList.size());
    }
}
