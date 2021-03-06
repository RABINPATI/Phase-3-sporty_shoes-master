package com.api.sportyShoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.sportyShoes.model.PurchaseReport;
import com.api.sportyShoes.model.Shoes;
import com.api.sportyShoes.service.SportShoesService;

@RestController
public class ShoesSearchController {
	
	@Autowired
	private SportShoesService service;
	
	/**
	 * Shoes search controller
	 * @return all shoe list
	 */
	
	@GetMapping("/admin/shoes/all")
	public ResponseEntity<List<Shoes>> getAllShoes(){
		return new ResponseEntity<List<Shoes>>(service.getAllShoes(), HttpStatus.OK);
	}
	
	
	/**
	 * Purchase Report Search Controller
	 * @param category
	 * @return purchase reports filtered by the category
	 */
	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	
	/**
	 * Purchase Report Search Controller
	 * @param dateInMs
	 * @return purchase reports filtered by date of purchase(in millisecond time)
	 */
	
	/**
	 * Purchase Report Search Controller
	 * @return all purchase reports
	 */
	@GetMapping("/admin/purchaseReport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReports(), HttpStatus.OK);
	}
}
