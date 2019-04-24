package cn.mxl.service;

import java.util.List;

import cn.mxl.pojo.Commodity;

public interface CommodityService {
	public List<Commodity> selectCommodityByUserName(String userName);
	public void deleteCommodityById(String commodity_id);
	public void updateCommodityAndLogisticsById(String commodity_id);
}
