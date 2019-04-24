package cn.mxl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mxl.dao.CommodityMapper;
import cn.mxl.pojo.Commodity;

@Service(value="CommodityServiceImpl")
public class CommodityServiceImpl implements CommodityService {
	@Resource(name="CommodityMapper")
	CommodityMapper commodityMapper;
	@Override
	public List<Commodity> selectCommodityByUserName(String userName) {
		// TODO Auto-generated method stub
		List<Commodity> commodity = commodityMapper.selectCommodityByUserName(userName);
		return commodity;
	}
	@Override
	public void deleteCommodityById(String commodity_id) {
		// TODO Auto-generated method stub
		commodityMapper.deleteCommodityById(commodity_id);
	}
	@Override
	public void updateCommodityAndLogisticsById(String commodity_id) {
		// TODO Auto-generated method stub
		commodityMapper.updateCommodityAndLogisticsById(commodity_id);
		
	}

}
