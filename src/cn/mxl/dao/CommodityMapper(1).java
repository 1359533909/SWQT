package cn.mxl.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.mxl.pojo.Commodity;

@Component(value="CommodityMapper")
public interface CommodityMapper {
	public List<Commodity> selectCommodityByUserName(String userName);
	public void deleteCommodityById(String commodity_id);
	public void updateCommodityAndLogisticsById(String commodity_id);
}
