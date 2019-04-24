package cn.mxl.service;

import java.util.List;

import cn.mxl.pojo.QueryCar;

public interface WorkerCarService {
	public List<QueryCar> selectWorkerCarByQueryCar(QueryCar queryCar);
	public QueryCar selectWorkerCarById(int id);
	public void updateWorkerByCar(QueryCar car);
	public void updateCarByCar(QueryCar car);
	public void deleteWorkerById(int id);
}
