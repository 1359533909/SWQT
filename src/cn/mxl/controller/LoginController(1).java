package cn.mxl.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mxl.pojo.Commodity;
import cn.mxl.pojo.Customer;
import cn.mxl.pojo.QueryVo;
import cn.mxl.pojo.Logistics;
import cn.mxl.service.CommodityService;
import cn.mxl.service.CustomerService;
import cn.mxl.service.LogisticsCompanyService;
import cn.mxl.service.LogisticsService;

@Controller
public class LoginController {

	@Resource(name="CustomerServiceImpl")
	CustomerService customerService;
	@Resource(name="CommodityServiceImpl")
	CommodityService commodityService;
	@Resource(name="LogisticsCompanyServiceImpl")
	LogisticsCompanyService logisticsCompanyService;
	@Resource(name="LogisticsServiceImpl")
	LogisticsService logisticsService;
//	@RequestMapping(value="/login.action")
//	public String LoginCheckUserAndPassword(Model model,HttpServletRequest request, HttpServletResponse response) {
//		PersonMessage personMessage=new PersonMessage();
//		String useraccount=request.getParameter("useraccount");
//		String password=request.getParameter("password");
//		char test=useraccount.charAt(0);
//
//		personMessage.setUseraccount(useraccount);
//		personMessage.setPassword(password);
//		if(test=='c'||test=='C') {
//			return "redirect:/logisticsCompany.action?account="+useraccount+"&password="+password;
//		}else if(test=='g'||test=='G'){
//			return "redirect:/PersonMessage.action?useraccount="+useraccount+"&password="+password;
//		}else {
//			return "redirect:/PersonMessage.action?useraccount="+useraccount+"&password="+password;
//		}
//	}
	@RequestMapping(value="/login_submit.action")
	public String LoginCheckUserAndPassword(QueryVo vo, Model model) {
		String account=vo.getAccount();
		char flag=account.charAt(0);
		Customer customer2 = customerService.selectCustomerByAccountAndPassword(vo);
		if(customer2==null) {
			return "redirect:login.jsp";
		}else if(flag=='c'||flag=='C') {
			vo.setCust_company(customer2.getCust_company());
			int company_id = logisticsCompanyService.selectCompanyIdByCompany(vo.getCust_company());
			model.addAttribute("cust_company", vo.getCust_company());
			model.addAttribute("companyId", company_id);
				return "logistics";
		}else if(flag=='g'||flag=='G'){
				return "customer";
		}else{
			List<Commodity> commodity = commodityService.selectCommodityByUserName(customer2.getCust_name());
			List<Logistics> logistics = logisticsService.selectlogisticsByUserName(customer2.getCust_name());
				model.addAttribute("customer", customer2);
				model.addAttribute("commodities", commodity);
				model.addAttribute("Logistics", logistics);
				return "user";
	    }
      }
	
	
	
}
