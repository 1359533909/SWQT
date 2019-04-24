package cn.mxl.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mxl.dao.CustomerMapper;
import cn.mxl.pojo.Customer;

@Controller
public class registerController {
	@Resource(name="CustomerMapper")
	CustomerMapper customerMapper;
	@RequestMapping(value="/registerCustomer.action")
	@ResponseBody
	public Customer registerCustomer(Customer customer){
		String account=customer.getAccount();
		char ac=account.charAt(0);
		if(ac=='g') {
			customer.setCust_name("");
			return customer;
		}
		if(customer.getCust_type().equals("∆’Õ®”√ªß")) {
			if(customer.getCust_company()!="") {
				customer.setCust_name("erro");
				return customer;
			}
		}
		customerMapper.insertCustomer(customer);
		return customer;
	}
}
