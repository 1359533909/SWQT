package cn.mxl.dao;

import org.springframework.stereotype.Component;

@Component(value="LogisticsCompanyMapper")
public interface LogisticsCompanyMapper {
	public String selectLogisticsCompanyNameById(int id);
	public int selectCompanyIdByCompany(String company);
}
