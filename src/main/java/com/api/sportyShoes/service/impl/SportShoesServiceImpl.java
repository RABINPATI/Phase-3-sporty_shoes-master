package com.api.sportyShoes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.sportyShoes.exceptionHandler.BusinessException;
import com.api.sportyShoes.model.PurchaseReport;
import com.api.sportyShoes.model.Shoes;
import com.api.sportyShoes.repository.PurchaseReportRepository;
import com.api.sportyShoes.repository.ShoesRepository;
import com.api.sportyShoes.service.SportShoesService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class SportShoesServiceImpl implements SportShoesService{
	
	@Autowired
	private ShoesRepository shoesRepo;
	
	@Autowired
	private PurchaseReportRepository prRepo;
	
	@PostConstruct
	public void init() {
		Shoes s1 = new Shoes(1,"Shoes Name 1","BasketballShoes",1000.24);
		Shoes s2 = new Shoes(2,"Shoes Name 2","CricketShoes",1100.24);
		Shoes s3 = new Shoes(3,"Shoes Name 3","RunningShoes",900.24);
		Shoes s4 = new Shoes(4,"Shoes Name 4","FootballShoes",1900.24);
		Shoes s5 = new Shoes(5,"Shoes Name 5","KabadiShoes",2900.24);
		Shoes s6 = new Shoes(6,"Shoes Name 6","rugbyShoes",3900.24);
		shoesRepo.save(s1);
		shoesRepo.save(s2);
		shoesRepo.save(s3);
		shoesRepo.save(s4);
		shoesRepo.save(s5);
		shoesRepo.save(s6);
		  
	    Date d = new Date();  
		
		PurchaseReport pr1 = new PurchaseReport(7,"user_1","RunningShoes",d,"adidas_runner:5,nike_airmax:10");
		PurchaseReport pr2 = new PurchaseReport(8,"user_2","CricketShoes",d,"adidas_cricket:5,nike_cricket:10");
		PurchaseReport pr3 = new PurchaseReport(9,"user_3","BasketballShoes",d,"adidas_basketball:5,nike_basketball:10");
		PurchaseReport pr4 = new PurchaseReport(10,"user_4","FootballShoes",d,"adidas_football:5,nike_football:10");
		PurchaseReport pr5 = new PurchaseReport(11,"user_5","KabadiShoes",d,"adidas_kabadi:5,nike_kabadi:10");
		PurchaseReport pr6 = new PurchaseReport(12,"user_6","rugbyShoes",d,"adidas_rugby:5,nike_rugby:10");
		
		prRepo.save(pr1);
		prRepo.save(pr2);
		prRepo.save(pr3);
		prRepo.save(pr4);
		prRepo.save(pr5);
		prRepo.save(pr6);
	}

	public Shoes createShoes(Shoes shoes) throws BusinessException {
		int id = shoes.getId();
		Shoes oldShoes = null;
		try {
			oldShoes = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldShoes!=null) throw new BusinessException("Shoe already exists with id: "+id);
		return shoesRepo.save(shoes);
	}

	public Shoes getShoesById(int id) throws BusinessException {
		Shoes shoes = null;
		try {
			if(id<=0) throw new BusinessException("Shoe Id can not be negative or zero");
			shoes = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("Shoe not found with Id: "+id);
		}
		return shoes;
	}
	
	public Shoes updateShoes(Shoes shoes) {
		return shoesRepo.save(shoes);
	}

	public void deleteShoesById(int id) throws BusinessException {
		try {
			shoesRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("SHoe does not exist with id: "+id);
		}
	}

	public List<Shoes> getAllShoes() {
		return shoesRepo.findAll();
	}

	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws BusinessException {
		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) throw new BusinessException("Purchase report already exists with id: "+id);
		return prRepo.save(pr);	
	}

	public PurchaseReport getPurchaseReportById(int id) throws BusinessException {
		PurchaseReport pr = null;
		try {
			if(id<=0) throw new BusinessException("Purchase Report Id can not be negative or zero");
			pr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("Purchase Report not found with Id: "+id);
		}
		return pr;
	}
	
	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		return prRepo.save(pr);
	}
	
	public void deletePurchaseReportById(int id) throws BusinessException {
		try {
			prRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("Puchase Report does not exist with Id: "+id);
		}
	}


	public List<PurchaseReport> getAllPurchaseReports() {
		return prRepo.findAll();
	}

	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		return prRepo.findByCategory(category);
	}
	

	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		return prRepo.findByDop(dop);
	}

}
