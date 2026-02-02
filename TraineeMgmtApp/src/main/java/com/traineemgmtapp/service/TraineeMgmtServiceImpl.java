package com.traineemgmtapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.traineemgmtapp.dao.TraineeMgmtDao;
import com.traineemgmtapp.entity.Trainee;
import com.traineemgmtapp.exception.TraineeDataAccessException;

@Service
@Transactional
public class TraineeMgmtServiceImpl implements TraineeMgmtService{
	private TraineeMgmtDao traineeDao;

	public TraineeMgmtServiceImpl(TraineeMgmtDao traineeDao) {
		this.traineeDao = traineeDao;
	}
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		try {
			return traineeDao.addTrainee(trainee);
		} catch (TraineeDataAccessException e) {
		 throw new RuntimeException("gg");
		}
	}
	
	@Override
	public Trainee getById(int id) {
		 try {
			return traineeDao.getTraineeById(id);
		 } catch (TraineeDataAccessException e) {
			 throw new RuntimeException("gg");
		 }
		
	}

}
