package cn.mxl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.utils.Page;
import cn.mxl.pojo.Logistics;
import cn.mxl.pojo.QueryCar;
import cn.mxl.pojo.QueryVo;
import cn.mxl.service.LogisticsCompanyService;
import cn.mxl.service.LogisticsService;
import cn.mxl.service.WorkerCarService;

@Controller
public class LogisticsController {
	@Resource(name="LogisticsServiceImpl")
	LogisticsService logisticsService;
	@Resource(name="LogisticsCompanyServiceImpl")
	LogisticsCompanyService logisticsCompanyService;
	@Resource(name="WorkerCarServiceImpl")
	WorkerCarService workerCarService;
	@RequestMapping("/logistics/list.action")
	public String queryLogistics(QueryVo vo,Model model){
//		if(vo.getCust_company() != null){
//			vo.setCust_company(new String(vo.getCust_company().getBytes("iso8859-1"), "utf-8"));
//		}
//		���ݻ���
		boolean wys=false;
		boolean yys=false;
		if(vo.getAcceptance()!=null||vo.getAcceptance()!="") {
		if(vo.getAcceptance().equals("δ����")) {
			wys=true;
		}
		if(vo.getAcceptance().equals("������")){
			yys=true;
		}
		}
		model.addAttribute("wys", wys);
		model.addAttribute("yys", yys);
		model.addAttribute("cust_company", vo.getCust_company());
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("commodity_id", vo.getCommodity_id());
//		�б���ʾ
		if(vo.getPage()==null) {
			vo.setPage(1);
		}
		vo.setStart((vo.getPage()-1)*vo.getSize());
		List<Logistics> logistics = logisticsService.selectlogisticsByVo(vo);
		int count =logisticsService.selectlogisticsCountByVo(vo);
		Page<Logistics> page=new Page<Logistics>();
		page.setPage(vo.getPage());  //��ǰҳ
		page.setRows(logistics);  //�����б�
		page.setSize(vo.getSize());  //ÿҳ��С
		page.setTotal(count);             //��������
		model.addAttribute("page", page);
//		ҳ����ת
		int companyId=logisticsCompanyService.selectCompanyIdByCompany(vo.getCust_company());
		model.addAttribute("companyId", companyId);
		return "logistics";
	}
	@RequestMapping("/logistics/detail.action")
	@ResponseBody
	public Logistics detail(int id) {
		Logistics logistics = logisticsService.selectLogisticsById(id);
		return logistics;
	}
//	�޸��û�
	@RequestMapping("logistics/update.action")
	public String update(Logistics logistics) {
		logisticsService.updateLogistics(logistics);
		return "logistics";
	}
//	ɾ���û�
	@RequestMapping("/logistics/delete.action")
	public String delete(int id) {
		System.out.println("id:"+id);
		logisticsService.deleteLogistics(id);
		return "logistics";
	}
	

	
	
	
//	��������
	@RequestMapping(value="logistics/carList.action")
	public String carPage(QueryCar queryCar,Model model) {
		model.addAttribute("companyId", queryCar.getCompany_id());
		String cust_company=logisticsCompanyService.selectLogisticsCompanyNameById(queryCar.getCompany_id());
		model.addAttribute("cust_company", cust_company);
		return "carManager";
	}
	@RequestMapping(value="logistics/redirect.action")
	public String redirect(QueryVo vo,Model model) {
		System.out.println("vo.getCompany_id:"+vo.getCompany_id());
		String  cust_company= logisticsCompanyService.selectLogisticsCompanyNameById(vo.getCompany_id());
		model.addAttribute("cust_company", cust_company);
		model.addAttribute("companyId", vo.getCompany_id());
		return "logistics";
	}
	@RequestMapping(value="logistics/carDisplay.action")
	public String carList(QueryCar queryCar,Model model){
//		���ݻ���
		model.addAttribute("worker_id", queryCar.getWorker_id());
		model.addAttribute("worker_name", queryCar.getWorker_name());
		model.addAttribute("car_number", queryCar.getCar_number());
		model.addAttribute("cust_company", queryCar.getCust_company());
		model.addAttribute("companyId", queryCar.getCompany_id());
		List<QueryCar> workerCars = workerCarService.selectWorkerCarByQueryCar(queryCar);
		model.addAttribute("rows", workerCars);
		System.out.println(queryCar.getWorker_name());
		return "carManager";
	}
//	����Ա����Ϣ�༭
	@RequestMapping(value="carManager/detail.action")
	@ResponseBody
	public QueryCar carManagerDetail(int id) {
		QueryCar car = workerCarService.selectWorkerCarById(id);
		return car;
	}
//	����Ա����Ϣ�޸�
	@RequestMapping(value="carManager/update.action")
	public String carManagerUpdate(QueryCar car) {
		workerCarService.updateCarByCar(car);
		workerCarService.updateWorkerByCar(car);
		return "carManager";
	}
//	ɾ��������Ϣ
	@RequestMapping(value="carManager/delete.action")
	public String carManagerDelete(int  id) {
		workerCarService.deleteWorkerById(id);
		return "carManager";
	}
}
