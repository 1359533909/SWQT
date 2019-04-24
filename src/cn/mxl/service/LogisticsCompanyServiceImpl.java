package cn.mxl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mxl.dao.LogisticsCompanyMapper;

@Service(value="LogisticsCompanyServiceImpl")
public class LogisticsCompanyServiceImpl implements LogisticsCompanyService {

	@Resource(name="LogisticsCompanyMapper")
	LogisticsCompanyMapper logisticsCompanyMapper;
	@Override
	public String selectLogisticsCompanyNameById(int id) {
		// TODO Auto-generated method stub
		String companyName = logisticsCompanyMapper.selectLogisticsCompanyNameById(id);
		return companyName;
	}
	@Override
	public int selectCompanyIdByCompany(String company) {
		// TODO Auto-generated method stub
		int companyId = logisticsCompanyMapper.selectCompanyIdByCompany(company);
		return companyId;
	}

}
