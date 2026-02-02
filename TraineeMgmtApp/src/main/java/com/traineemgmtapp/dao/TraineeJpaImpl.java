package com.traineemgmtapp.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.traineemgmtapp.entity.Trainee;
import com.traineemgmtapp.exception.TraineeDataAccessException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Profile("prod")
public class TraineeJpaImpl implements TraineeMgmtDao{

	@PersistenceContext
    private EntityManager em;

    @Override
    public Trainee addTrainee(Trainee trainee) throws TraineeDataAccessException {
        try {
            em.persist(trainee);
        } catch (Exception e) {
            throw new TraineeDataAccessException("Trainee could not be added", e);
        }
		return trainee;
    }

    @Override
    public Trainee getTraineeById(int id) throws TraineeDataAccessException{
        Trainee trainee = em.find(Trainee.class, id);
        if (trainee == null) {
            throw new TraineeDataAccessException("Trainee not found");
        }
        return trainee;
    }

}
