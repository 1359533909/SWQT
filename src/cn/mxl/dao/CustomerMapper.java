package cn.mxl.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.mxl.pojo.Customer;
import cn.mxl.pojo.QueryVo;

@Component("CustomerMapper")
public interface CustomerMapper {
	public Customer selectCustomerByAccountAndPassword(QueryVo vo);
	public void Customer(Customer customer);
	public List<Customer> selectCustomer(Customer customer);
	public Customer selectCustomerById(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomerById(int id);
	public void insertCustomer(Customer customer);
}
