package com.api.sportyShoes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sportyShoes.model.Shoes;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Integer>{
	
}
