package com.api.sportyShoes.service;

import java.util.Date;
import java.util.List;

import com.api.sportyShoes.exceptionHandler.BusinessException;
import com.api.sportyShoes.model.PurchaseReport;
import com.api.sportyShoes.model.Shoes;

public interface SportShoesService {
	
	public Shoes createShoes(Shoes shoes) throws BusinessException;
	public Shoes getShoesById(int id) throws BusinessException;
	public Shoes updateShoes(Shoes shoes);
	public void deleteShoesById(int id) throws BusinessException;
	public List<Shoes> getAllShoes();
	
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws BusinessException;
	public PurchaseReport getPurchaseReportById(int id) throws BusinessException;
	public PurchaseReport updatePurchaseReport(PurchaseReport pr);
	public void deletePurchaseReportById(int id) throws BusinessException;
	public List<PurchaseReport> getAllPurchaseReports();
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category);
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop);

}
