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

import com.aht.project.entity.Parts;
import com.aht.project.entity.ServiceResult;
import com.aht.project.serviceImpl.PartsServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/parts")
public class PartsController {

    private PartsServiceImpl partsServiceImpl;

    public PartsController(PartsServiceImpl partsServiceImpl) {
        this.partsServiceImpl = partsServiceImpl;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        ServiceResult serviceResult = partsServiceImpl.findAll();
        List<Parts> parts = (List<Parts>) serviceResult.getData();
        if (parts.size() > 0) {
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Object> addParts(@RequestBody Parts parts) {

        ServiceResult serviceResult = partsServiceImpl.save(parts);
        if (serviceResult.isValid()) {
            return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteParts(@PathVariable("id") int id) {
        ServiceResult serviceResult = partsServiceImpl.delete(id);
        if (serviceResult.isValid()) {
            return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateParts(@PathVariable("id") int id, @RequestBody Parts parts) {
        ServiceResult serviceResult = partsServiceImpl.update(id, parts);
        if (serviceResult.isValid()) {
            return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
