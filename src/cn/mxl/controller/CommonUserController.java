package cn.mxl.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mxl.service.CommodityService;


@Controller
public class CommonUserController {
	@Resource(name="CommodityServiceImpl")
	CommodityService commodityService;
	@RequestMapping(method=RequestMethod.POST,value="/registerCommodity.action")
	@ResponseBody
	public String updateCommdity(String id) {
		commodityService.updateCommodityAndLogisticsById(id);
		return "user";
	};
}
