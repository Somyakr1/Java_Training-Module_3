package com.traineemgmtapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineemgmtapp.entity.Trainee;
import com.traineemgmtapp.service.TraineeMgmtService;

@RestController
@RequestMapping(path = "/api/trainees")
public class TraineeMgmtController {
	private final TraineeMgmtService traineeService;
	
	public TraineeMgmtController(TraineeMgmtService traineeService) {
		this.traineeService = traineeService;
	}
	
	@PostMapping
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(traineeService.addTrainee(trainee));
    }
	
	@GetMapping(path = "/{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(traineeService.getById(id));
    }
}
