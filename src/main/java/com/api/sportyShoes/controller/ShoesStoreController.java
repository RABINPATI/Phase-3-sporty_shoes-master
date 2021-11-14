package com.api.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sportyShoes.exceptionHandler.BusinessException;
import com.api.sportyShoes.model.PurchaseReport;
import com.api.sportyShoes.model.Shoes;
import com.api.sportyShoes.service.SportShoesService;

@RestController
public class ShoesStoreController {

	/*
	 * @Autowired private SportyShoesService service;
	 */
	
	@Autowired
	private SportShoesService implService;

	private MultiValueMap<String, String> errorMap;

	/**
	 * Shoes post request controller
	 * 
	 * @param shoes
	 * @return ResponseEntity<Shoe> with newly created Shoe
	 */
	@PostMapping("/admin/shoes")
	public ResponseEntity<Shoes> createShoe(@RequestBody Shoes shoes) {
		try {
			return new ResponseEntity<>(implService.createShoes(shoes), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Shoes get request controller
	 * 
	 * @param id
	 * @return ResponseEntity<Shoes> with the given id
	 */
	@GetMapping("/admin/shoes/{id}")
	public ResponseEntity<Shoes> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(implService.getShoesById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Shoes put(update) request controller
	 * 
	 * @param shoes
	 * @return ResponseEntity<Shoes> with updated shoe
	 */
	@PutMapping("/admin/shoes")
	public ResponseEntity<Shoes> updateShoe(@RequestBody Shoes shoes) {
		return new ResponseEntity<>(implService.updateShoes(shoes), HttpStatus.OK);
	}

	/**
	 * Shoes delete request controller
	 * 
	 * @param id
	 * @return ResponseEntity<String> containing the status of delete operation
	 */
	@DeleteMapping("/admin/shoes/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			implService.deleteShoesById(id);
			return new ResponseEntity<>("Succesfully deleted shoes with id: " + id, HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purchase Report post request controller
	 * 
	 * @param pr - Purchase Report
	 * @return ResponseEntity<PurchaseReport> with newly created Purchase Report
	 */
	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr) {
		try {
			return new ResponseEntity<>(implService.createPurchaseReport(pr), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purchase Report get request controller
	 * 
	 * @param id
	 * @return ResponseEntity<PurchaseReport> with given id
	 */
	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(implService.getPurchaseReportById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Purchase Report put(update) request controller
	 * 
	 * @param pr
	 * @return ResponseEntity<PurchaseReport> containing updated Purchase Report
	 */
	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr) {
		return new ResponseEntity<>(implService.updatePurchaseReport(pr), HttpStatus.OK);
	}

	/**
	 * Purchase Report delete request controller
	 * 
	 * @param id
	 * @return ResponseEntity<String> containing the status of delete request.
	 */
	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
		try {
			implService.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
}
