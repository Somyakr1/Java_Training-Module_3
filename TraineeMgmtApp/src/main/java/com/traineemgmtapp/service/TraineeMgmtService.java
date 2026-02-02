package com.traineemgmtapp.service;

import com.traineemgmtapp.entity.Trainee;

public interface TraineeMgmtService {
	public Trainee addTrainee(Trainee trainee);
	public Trainee getById(int id);
}
