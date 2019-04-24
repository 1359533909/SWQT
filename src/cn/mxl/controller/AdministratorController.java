package cn.mxl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mxl.pojo.Customer;
import cn.mxl.service.CustomerService;

@Controller
public class AdministratorController {
	@Resource(name="CustomerServiceImpl")
	CustomerService customerService;
	@RequestMapping("/customer/list.action")
	public String listCustomer(Customer customer,Model model) {
//		���ݻ���
		boolean pt=false;
		boolean qy=false;
		boolean gl=false;
		boolean st=false;
		boolean yt=false;
		boolean sf=false;
		boolean tt=false;
		if(customer.getCust_type()!=null) {
		if(customer.getCust_type().equals("��ͨ�û�")) {
			pt=true;
		}
		if(customer.getCust_type().equals("��ҵ�û�")) {
			qy=true;
			if(customer.getCust_company()!=null) {
				if(customer.getCust_company().equals("��ͨ������˾")) {
					st=true;
				}
				if(customer.getCust_company().equals("Բͨ������˾")) {
					yt=true;
				}
				if(customer.getCust_company().equals("˳��������˾")) {
					sf=true;
				}
				if(customer.getCust_company().equals("����������˾")) {
					tt=true;
				}
			}
		}
		if(customer.getCust_type().equals("����Ա")) {
			gl=true;
		}
		}
		model.addAttribute("pt", pt);
		model.addAttribute("qy", qy);
		model.addAttribute("gl", gl);
		model.addAttribute("st", st);
		model.addAttribute("yt", yt);
		model.addAttribute("sf", sf);
		model.addAttribute("tt", tt);
		model.addAttribute("cust_name", customer.getCust_name());
		model.addAttribute("account", customer.getAccount());
//		�����б���ʾ
		List<Customer> customerList = customerService.selectCustomer(customer);
		model.addAttribute("customerList", customerList);
		return "customer";
	}
	
	@RequestMapping("customer/detail.action")
	@ResponseBody
	public Customer detail(int id) {
		Customer customer = customerService.selectCustomerById(id);
		return customer;
	}
	@RequestMapping(value="customer/update.action")
	public String update(Customer customer) {
		customerService.updateCustomer(customer);
		return "customer";
	}
	
//	�û�ɾ��
	@RequestMapping(value="customer/delete.action")
	public String delete(int id) {
		customerService.deleteCustomerById(id);
		return "customer";
	}
}
