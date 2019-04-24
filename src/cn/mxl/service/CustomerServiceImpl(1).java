package cn.mxl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mxl.dao.CustomerMapper;
import cn.mxl.pojo.Customer;
import cn.mxl.pojo.QueryVo;
@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
	@Resource(name="CustomerMapper")
	CustomerMapper customerMapper;
	@Override
	public Customer selectCustomerByAccountAndPassword(QueryVo vo) {
		// TODO Auto-generated method stub
		Customer customer2 = customerMapper.selectCustomerByAccountAndPassword(vo);
		return customer2;
	}
	@Override
	public void insertCustomer(Customer customer) {
		customerMapper.insertCustomer(customer);
		
	}
	@Override
	public List<Customer> selectCustomer(Customer customer) {
		// TODO Auto-generated method stub
		List<Customer> customer2 = customerMapper.selectCustomer(customer);
		return customer2;
	}
	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerMapper.selectCustomerById(id);
		return customer;
	}
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.updateCustomer(customer);
		
	}
	@Override
	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		customerMapper.deleteCustomerById(id);
	}

}
