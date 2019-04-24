package cn.mxl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mxl.dao.WorkerCarMapper;
import cn.mxl.pojo.QueryCar;

@Service(value="WorkerCarServiceImpl")
public class WorkerCarServiceImpl implements WorkerCarService {
	@Resource(name="WorkerCarMapper")
	WorkerCarMapper workerCarMapper;
	@Override
	public List<QueryCar> selectWorkerCarByQueryCar(QueryCar queryCar) {
		// TODO Auto-generated method stub
		List<QueryCar> workerCars = workerCarMapper.selectWorkerCarByQueryCar(queryCar);
		return workerCars;
	}
	@Override
	public QueryCar selectWorkerCarById(int id) {
		// TODO Auto-generated method stub
		QueryCar car = workerCarMapper.selectWorkerCarById(id);
		return car;
	}
	@Override
	public void updateWorkerByCar(QueryCar car) {
		// TODO Auto-generated method stub
		workerCarMapper.updateWorkerByCar(car);
	}
	@Override
	public void updateCarByCar(QueryCar car) {
		// TODO Auto-generated method stub
		workerCarMapper.updateCarByCar(car);
		
	}
	@Override
	public void deleteWorkerById(int id) {
		// TODO Auto-generated method stub
		workerCarMapper.deleteWorkerById(id);
		
	}

}
