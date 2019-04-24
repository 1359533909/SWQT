package cn.mxl.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.mxl.pojo.QueryCar;
@Component(value="WorkerCarMapper")
public interface WorkerCarMapper {
	public List<QueryCar> selectWorkerCarByQueryCar(QueryCar queryCar);
	public QueryCar selectWorkerCarById(int id);
	public void updateWorkerByCar(QueryCar car);
	public void updateCarByCar(QueryCar car);
	public void deleteWorkerById(int id);
}
