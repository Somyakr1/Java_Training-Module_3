package com.traineemgmtapp.dao;

import com.traineemgmtapp.entity.Trainee;
import com.traineemgmtapp.exception.TraineeDataAccessException;

public interface TraineeMgmtDao {
	public Trainee addTrainee(Trainee trainee) throws TraineeDataAccessException;
	public Trainee getTraineeById(int traineeId) throws TraineeDataAccessException;
}
