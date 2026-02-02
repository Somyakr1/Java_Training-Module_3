package com.traineemgmtapp.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.traineemgmtapp.entity.Trainee;
import com.traineemgmtapp.exception.TraineeDataAccessException;

@Repository
@Profile("dev")
public class TraineeJdbcImpl implements TraineeMgmtDao{

	 private final JdbcTemplate jdbcTemplate;

	    public TraineeJdbcImpl(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    @Override
	    public Trainee addTrainee(Trainee trainee) throws TraineeDataAccessException {
	        try {
	            jdbcTemplate.update("INSERT INTO trainee(name, age, marks) VALUES (?, ?, ?)",
	                trainee.getName(), trainee.getAge(), trainee.getMarks());
	        } catch (Exception e) {
	            throw new TraineeDataAccessException("JDBC insert failed", e);
	        }
			return trainee;
	    }

	    @Override
	    public Trainee getTraineeById(int id) throws TraineeDataAccessException {
	        try {
	        	return jdbcTemplate.queryForObject(
	                    "SELECT id, name, age, marks FROM trainee WHERE id = ?",
	                    (rs, rowNum) -> {
	                        Trainee trainee = new Trainee();
	                        trainee.setId(rs.getInt("id"));
	                        trainee.setName(rs.getString("name"));
	                        trainee.setAge(rs.getInt("age"));
	                        trainee.setMarks(rs.getInt("marks"));
	                        return trainee;
	                    },
	                    id
	                );
	        } catch (Exception e) {
	            throw new TraineeDataAccessException("Trainee not found", e);
	        }
	    }

}
