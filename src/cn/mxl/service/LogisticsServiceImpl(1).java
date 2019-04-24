package cn.mxl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mxl.dao.LogisticsMapper;
import cn.mxl.pojo.Logistics;
import cn.mxl.pojo.QueryVo;

@Service(value="LogisticsServiceImpl")
public class LogisticsServiceImpl implements LogisticsService {
	@Resource(name="LogisticsMapper")
	LogisticsMapper logisticsMapper;
	@Override
	public List<Logistics> selectlogisticsByUserName(String userName) {
		// TODO Auto-generated method stub
		List<Logistics> logistics = logisticsMapper.selectlogisticsByUserName(userName);
		return logistics;
	}
	@Override
	public List<Logistics> selectlogisticsByCompanyName(QueryVo vo) {
		// TODO Auto-generated method stub
		List<Logistics> logistics = logisticsMapper.selectlogisticsByCompanyName(vo);
		return logistics;
	}
	@Override
	public int selectlogisticsCountByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		int count = logisticsMapper.selectlogisticsCountByCompanyName(companyName);
		return count;
	}
	@Override
	public List<Logistics> selectlogisticsByVo(QueryVo vo) {
		// TODO Auto-generated method stub
		List<Logistics> logistics = logisticsMapper.selectlogisticsByVo(vo);
		return logistics;
	}
	@Override
	public int selectlogisticsCountByVo(QueryVo vo) {
		// TODO Auto-generated method stub
		int count = logisticsMapper.selectlogisticsCountByVo(vo);
		return count;
	}
	@Override
	public Logistics selectLogisticsById(int id) {
		// TODO Auto-generated method stub
		Logistics logistics = logisticsMapper.selectLogisticsById(id);
		return logistics;
	}
	@Override
	public void updateLogistics(Logistics logistics) {
		// TODO Auto-generated method stub
		logisticsMapper.updateLogistics(logistics);
	}
	@Override
	public void deleteLogistics(int id) {
		// TODO Auto-generated method stub
		logisticsMapper.deleteLogistics(id);
		
	}

}
