package cn.mxl.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.mxl.pojo.Logistics;
import cn.mxl.pojo.QueryVo;

@Component(value="LogisticsMapper")
public interface LogisticsMapper {
	public List<Logistics> selectlogisticsByUserName(String userName);
	public List<Logistics> selectlogisticsByCompanyName(QueryVo vo);
	public int selectlogisticsCountByCompanyName(String companyName);
	public List<Logistics> selectlogisticsByVo(QueryVo vo);
	public int selectlogisticsCountByVo(QueryVo vo);
	public Logistics selectLogisticsById(int id);
	public void updateLogistics(Logistics logistics);
	public void deleteLogistics(int id);
}
