package cn.mxl.service;

import java.util.List;

import cn.mxl.pojo.Customer;
import cn.mxl.pojo.QueryVo;

public interface CustomerService {
	public Customer selectCustomerByAccountAndPassword(QueryVo vo);
	public void insertCustomer(Customer customer);
	public List<Customer> selectCustomer(Customer customer);
	public Customer selectCustomerById(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomerById(int id);
}
