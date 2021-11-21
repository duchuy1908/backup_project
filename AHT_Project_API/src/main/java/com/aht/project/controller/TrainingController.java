package com.aht.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.Training;
import com.aht.project.serviceImpl.TrainingServiceImpl;
import com.aht.project.entity.ServiceResult;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/training")
public class TrainingController {

	private TrainingServiceImpl trainingServiceImpl;

	public TrainingController(TrainingServiceImpl trainingServiceImpl) {
		this.trainingServiceImpl = trainingServiceImpl;
	}

	@GetMapping
	public ResponseEntity<Object> getAll() {
		ServiceResult serviceResult = trainingServiceImpl.findAll();
		List<Training> trainings = (List<Training>) serviceResult.getData();
		if (trainings.size() > 0) {
			return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@PostMapping
	public ResponseEntity<Object> addTraining(@RequestBody Training training) {

		ServiceResult serviceResult = trainingServiceImpl.save(training);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTraining(@PathVariable("id") int id) {
		ServiceResult serviceResult = trainingServiceImpl.delete(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateTraining(@PathVariable("id") int id, @RequestBody Training training) {
		ServiceResult serviceResult = trainingServiceImpl.update(id, training);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
