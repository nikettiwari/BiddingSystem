package com.example.biddingsystem.repository;

import org.springframework.stereotype.Repository;

import com.example.biddingsystem.pojo.Product;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
	
	Optional<Product> findById(String productId);
	
	
	@Query(value="SELECT * FROM Product  WHERE isProductAssigned = false and endTimeForBid<:timestamp", nativeQuery=true)
	List<Product> findProductNotAssigned(@Param("timestamp")Timestamp timestamp);
	

}
